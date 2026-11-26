package com.codeturtle.kmppractice.data

import com.codeturtle.kmppractice.data.model.UserDtoItem
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class UserApi(
    private val client: HttpClient
) {

    suspend fun getUsers(): List<UserDtoItem> {

        return client
            .get("https://jsonplaceholder.typicode.com/users")
            .body()
    }
}