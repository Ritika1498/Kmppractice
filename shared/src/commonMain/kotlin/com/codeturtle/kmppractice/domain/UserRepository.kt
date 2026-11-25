package com.codeturtle.kmppractice.domain

interface UserRepository {
    suspend fun getUsers(): List<User>
    suspend fun refreshUsers(): List<User>
}