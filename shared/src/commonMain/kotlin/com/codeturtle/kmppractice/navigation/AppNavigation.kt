package com.codeturtle.kmppractice.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.savedstate.read
import com.codeturtle.kmppractice.presentation.UserDetailsScreen
import com.codeturtle.kmppractice.presentation.UserScreen

@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.UserList.route
    ) {

        composable(Screen.UserList.route) {

            UserScreen(
                onUserClick = { userId ->
                    navController.navigate(
                        Screen.UserDetails.createRoute(userId)
                    )
                }
            )
        }

        composable(
            route = Screen.UserDetails.route,
            arguments = listOf(
                navArgument("userId") {
                    type = NavType.IntType
                }
            )
        ) { backStackEntry ->

            val userId = requireNotNull(
                backStackEntry.arguments?.read { getInt("userId") }
            ) {
                "Missing or invalid required navigation argument: userId"
            }

            UserDetailsScreen(userId = userId)
        }
    }
}
