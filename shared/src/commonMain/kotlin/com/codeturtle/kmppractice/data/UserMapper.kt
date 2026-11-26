package com.codeturtle.kmppractice.data

import com.codeturtle.kmppractice.data.model.UserDtoItem
import com.codeturtle.kmppractice.domain.User

fun UserDtoItem.toDomain(): User {
    return User(
        id = id,
        name = name,
        email = email
    )
}