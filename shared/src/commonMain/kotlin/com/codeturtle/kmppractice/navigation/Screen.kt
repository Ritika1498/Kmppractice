package com.codeturtle.kmppractice.navigation

import kotlinx.serialization.Serializable

sealed class Screen(
    val route: String
) {
    data object UserList : Screen("user_list")

    data object UserDetails : Screen("user_details/{userId}") {
        fun createRoute(userId: Int): String {
            return "user_details/$userId"
        }
    }
}