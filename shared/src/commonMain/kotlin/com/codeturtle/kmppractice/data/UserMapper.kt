package com.codeturtle.kmppractice.data

import com.codeturtle.kmppractice.domain.User

fun UserDto.toDomain(): User {
    return User(
        id = id,
        name = name,
        email = email
    )
}