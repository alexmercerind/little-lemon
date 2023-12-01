package com.alexmercerind.littlelemon.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.alexmercerind.littlelemon.repository.UserRepository
import com.alexmercerind.littlelemon.ui.theme.LittleLemonTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {

            val navController = rememberNavController()

            LittleLemonTheme {
                NavHost(
                    navController = navController,
                    startDestination = if (UserRepository(application).isLogged) Home.route else Onboarding.route,
                    builder = {
                        composable(Onboarding.route) {
                            OnboardingScreen(navController)
                        }
                        composable(Profile.route) {
                            ProfileScreen(navController)
                        }
                        composable(Home.route) {
                            HomeScreen(navController)
                        }
                    }
                )
            }
        }
    }
}
