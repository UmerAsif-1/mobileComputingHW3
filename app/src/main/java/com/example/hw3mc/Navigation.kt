package com.example.hw3mc

import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.hw3mc.data.UserViewModel

@Composable
fun Navigation(
    viewModel: UserViewModel
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.FrontScreen.route
    ) {
        composable(
            route = Screen.FrontScreen.route
        ) {
            FrontScreen(navController, viewModel)
        }
        composable(
            route = Screen.SecondScreen.route
        ) {
            SecondScreen(navController, viewModel)
        }
    }
}
