package com.example.walkie_talkie.system.presentation.app_design.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.walkie_talkie.system.presentation.app_design.ui.screens.ai.ai_chat_room.MainAiChat

@RequiresApi(Build.VERSION_CODES.O)
fun NavGraphBuilder.aiScreen(navController: NavController) {
    navigation(
        startDestination = Screen.Ai.route ,
        route = Screen.AIGraph.route
    ) {
        composable(Screen.Ai.route ) {
            MainAiChat(navController)
        }
    }
}