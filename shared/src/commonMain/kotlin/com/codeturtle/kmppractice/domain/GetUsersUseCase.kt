package com.codeturtle.kmppractice.domain

import com.codeturtle.kmppractice.data.UserApi
import com.codeturtle.kmppractice.data.toDomain
import com.codeturtle.kmppractice.network.HttpClientProvider

class GetUsersUseCase{
    private val userApi = UserApi(
        client = HttpClientProvider.client
    )

    suspend operator fun invoke(): List<User> {
        return userApi.getUsers().map { dto ->
            dto.toDomain()
        }
    }
}