package com.example.parishmobileapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.parishmobileapp.ui.auth.LoginScreen
import com.example.parishmobileapp.ui.auth.RegisterScreen
import com.example.parishmobileapp.ui.home.DashboardScreen


@Composable
fun AppNavHost(
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = "login"
    ) {
        composable("login") {
            LoginScreen(
                onNavigateToRegister = {
                    navController.navigate("register")
                },
                onNavigateToDashboard = {    // add this
                    navController.navigate("dashboard")
                }
            )
        }


        composable("register") {
            RegisterScreen(
                onNavigateToLogin = {
                    navController.popBackStack() // go back to login
                }
            )
        }
    }
}
