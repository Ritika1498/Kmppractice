package com.codeturtle.kmppractice.data

import app.cash.sqldelight.Query
import com.codeturtle.kmppractice.data.local.UserLocalDataSource
import com.codeturtle.kmppractice.domain.User
import com.codeturtle.kmppractice.domain.UserRepository

class UserRepositoryImpl(
    private val userApi: UserApi,
    private val localDataSource: UserLocalDataSource,

    ) : UserRepository {

    fun observeUsers() = localDataSource.observeUsers()

    override suspend fun getUsers(): List<User> {
        return userApi.getUsers().map { dto ->
            dto.toDomain()
        }
    }

    override suspend fun refreshUsers() : List<User> {
        val users = userApi.getUsers()

        users.forEach { user ->
            localDataSource.insertUser(
                id = user.id,
                name = user.name,
                email = user.email
            )
        }
        return users.map { it.toDomain() }
    }

}