package com.codeturtle.kmppractice.data.local

import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList
import com.codeturtle.kmppractice.db.AppDatabase
import com.codeturtle.kmppractice.db.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.Flow

class UserLocalDataSource(
    private val database: AppDatabase
) {

    private val queries = database.userQueries

    fun getAllUsers() =
        queries.selectAllUsers()

    fun insertUser(
        id: Int,
        name: String,
        email: String
    ) {
        queries.insertUser(
            id = id.toLong(),
            name = name,
            email = email
        )
    }

    fun deleteUser(id: Int) {
        queries.deleteUser(id.toLong())
    }

    fun observeUsers(): Flow<List<User>> {
        return queries
            .selectAllUsers()
            .asFlow()
            .mapToList(Dispatchers.IO)
    }
}