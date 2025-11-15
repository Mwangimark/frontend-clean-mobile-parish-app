package com.example.parishmobileapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.lifecycle.lifecycleScope
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.parishmobileapp.ui.auth.LoginScreen
import com.example.parishmobileapp.ui.auth.RegisterScreen
import com.example.parishmobileapp.ui.home.DashboardScreen
import com.parishapp.mobile.data.ApiClient
import com.parishapp.mobile.data.UserApi
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    private val userApi = ApiClient.retrofit.create(UserApi::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()

            MaterialTheme {
                Surface {
                    NavHost(
                        navController = navController,
                        startDestination = "login"
                    ) {
                        composable("register") {
                            RegisterScreen(
                                onNavigateToLogin = {
                                    navController.navigate("login")
                                },
                                onGoogleSignIn = {
                                    // TODO: handle Google sign in (for now just log)
                                    Log.d("RegisterScreen", "Google Sign In clicked")
                                }
                            )
                        }

                        composable("login") {
                            LoginScreen(
                                onNavigateToRegister = { navController.navigate("register") },
                                onNavigateToDashboard = { navController.navigate("dashboard") }
                            )
                        }

                        composable("dashboard") {
                            DashboardScreen()
                        }


                    }
                }
            }
        }

        // ✅ Example API call
        lifecycleScope.launch {
            try {
                val users = userApi.getUsers()
                Log.d("API", "Users: $users")
            } catch (e: Exception) {
                Log.e("API", "Error: ${e.message}")
            }
        }
    }
}
