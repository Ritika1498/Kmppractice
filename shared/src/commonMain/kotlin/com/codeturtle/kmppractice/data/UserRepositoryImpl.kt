package com.codeturtle.kmppractice.data

import app.cash.sqldelight.Query
import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList
import com.codeturtle.kmppractice.data.local.UserLocalDataSource
import com.codeturtle.kmppractice.data.model.UserDtoItem
import com.codeturtle.kmppractice.db.AppDatabase
import com.codeturtle.kmppractice.db.UserQueries
import com.codeturtle.kmppractice.domain.User
import com.codeturtle.kmppractice.domain.UserRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class UserRepositoryImpl(
    private val userApi: UserApi,
    private val database: AppDatabase
) : UserRepository {

    private val queries = database.userQueries

    override fun getUsers(): Flow<List<User>> {
        return queries
            .selectAllUsers()
            .asFlow()
            .mapToList(Dispatchers.Default)
            .map { databaseUsers ->

                databaseUsers.map { dbUser ->
                    User(
                        id = dbUser.id.toInt(),
                        name = dbUser.name,
                        email = dbUser.email
                    )
                }
            }
    }

    override suspend fun refreshUsers() {

        val apiUsers: List<UserDtoItem> = userApi.getUsers()

        queries.transaction {
            queries.deleteAllUsers()

            apiUsers.forEach { user ->
                queries.insertUser(
                    id = user.id.toLong(),
                    name = user.name,
                    email = user.email
                )
            }
        }
    }
}