package com.codeturtle.kmppractice.domain

import com.codeturtle.kmppractice.data.UserApi
import com.codeturtle.kmppractice.data.toDomain
import com.codeturtle.kmppractice.network.HttpClientProvider
import kotlinx.coroutines.flow.Flow

class GetUsersUseCase(
    private val repository: UserRepository
) {
    operator fun invoke(): Flow<List<User>> {
        return repository.getUsers()
    }

    suspend fun refresh() {
        repository.refreshUsers()
    }
}