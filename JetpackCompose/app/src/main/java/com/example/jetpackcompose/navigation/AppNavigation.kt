package com.example.jetpackcompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.jetpackcompose.screen.UserDetailsScreen
import com.example.jetpackcompose.screen.UserListScreen

@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "user_list") {
        composable("user_list") {
            UserListScreen(navController = navController)
        }
        composable("user_details/{userId}") { backStackEntry ->
            val userId = backStackEntry.arguments?.getString("userId") ?: return@composable
            UserDetailsScreen(navController = navController, userId = userId.toInt())
        }
    }
}