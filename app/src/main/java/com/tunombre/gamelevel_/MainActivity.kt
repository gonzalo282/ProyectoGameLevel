package com.tunombre.gamelevel_

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.tunombre.gamelevel_.feature_account.AccountScreen
import com.tunombre.gamelevel_.feature_auth.SignInScreen
import com.tunombre.gamelevel_.feature_home.HomeScreen
import com.tunombre.gamelevel_.ui.theme.GameLevel_Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            GameLevel_Theme {
                AppNavigation()
            }
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "signin"
    ) {
        // Pantalla de SignIn
        composable("signin") {
            SignInScreen(
                onBack = { /* navController.popBackStack() si quieres */ },
                onCreateAccount = { /* TODO: ir a registro */ },

                // Por ahora todas las acciones llevan a Home
                onGoogle = { navController.navigate("home") },
                onFacebook = { navController.navigate("home") },
                onSteam = { navController.navigate("home") },
                onDiscord = { navController.navigate("home") },
                onTwitch = { navController.
                navigate("home") },
                onTwitter = { navController.navigate("home") },

                onLoginWithPassword = { _ -> navController.navigate("home") },
                onMagicLink = { _ -> navController.navigate("home") }
            )
        }

        // Pantalla Home
        composable("home") {
            AccountScreen()
        }

        composable("home") {
            AccountScreen()
        }
        // Pantalla Home
        composable("home") {
            AccountScreen(
                onJoinNow = { navController.navigate("signin") }
            )
        }


    }



}
