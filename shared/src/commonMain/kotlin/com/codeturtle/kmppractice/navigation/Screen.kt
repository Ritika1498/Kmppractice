package com.codeturtle.kmppractice.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class Screen() {
    @Serializable
    object HomeScreen : Screen()
    @Serializable
    object LoginScreen : Screen()
    @Serializable
    object UserScreen : Screen()
}