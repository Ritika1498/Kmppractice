package com.codeturtle.kmppractice.domain

import kotlinx.coroutines.flow.Flow

interface UserRepository {
    fun getUsers(): Flow<List<User>>

    suspend fun refreshUsers()
}