package com.example.walkie_talkie.system.presentation.app_design.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.walkie_talkie.system.presentation.app_design.ui.screens.authaintcation.LoginAndSignUp
import com.example.walkie_talkie.system.presentation.app_design.ui.screens.authaintcation.singin.SignIn
import com.example.walkie_talkie.system.presentation.app_design.ui.screens.authaintcation.welcome.WelcomeMainFun

@RequiresApi(Build.VERSION_CODES.S)
fun NavGraphBuilder.auth(navController: NavController) {
    navigation(
        startDestination = Screen.Welcome.route ,
        Screen.AuthGraph.route ,
    ) {
        composable(Screen.Welcome.route) {
            WelcomeMainFun(navController)
        }
        composable(Screen.Login.route) {
            LoginAndSignUp(navController)

        }
        composable(Screen.Signin.route) {
            SignIn(navController)
        }
        composable(Screen.ForgotPassword.route) {}
        composable(Screen.Verification.route) {}
    }
}