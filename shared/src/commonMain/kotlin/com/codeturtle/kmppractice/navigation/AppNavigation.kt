package com.codeturtle.kmppractice.navigation


/*import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute

import com.example.myapp.features.login.LoginScreen
import com.example.myapp.features.home.HomeScreen
import com.example.myapp.features.users.UserDetailsScreen

@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Login
    ) {

        // Login destination
        composable<Screen.Login> {

            LoginScreen(
                onLoginClick = {

                    navController.navigate(Screen.Home) {
                        popUpTo<Screen.Login> {
                            inclusive = true
                        }
                    }
                }
            )
        }

        // Home destination
        composable<Screen.Home> {

            HomeScreen(
                onUserClick = { userId ->

                    navController.navigate(
                        Screen.UserDetails(userId)
                    )
                }
            )
        }

        // User details destination
        composable<Screen.UserDetails> { backStackEntry ->

            val route = backStackEntry.toRoute<Screen.UserDetails>()

            UserDetailsScreen(
                userId = route.userId,
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}*/



