package com.example.walkie_talkie.system.presentation.app_design.navigation


import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.walkie_talkie.system.presentation.app_design.ui.componant.errors.ErrorScreen
import com.example.walkie_talkie.system.presentation.app_design.ui.screens.home.HomeScreen
import com.example.walkie_talkie.system.presentation.app_design.ui.screens.home.channels.ChannelsScreen
import com.example.walkie_talkie.system.presentation.app_design.ui.screens.home.chats.ChatsScreen
import com.example.walkie_talkie.system.presentation.app_design.ui.screens.home.chats.chat_room.MainChatRoomFun
import com.example.walkie_talkie.system.presentation.app_design.ui.screens.home.status.StatusScreen


fun NavGraphBuilder.home(navController: NavController) {
    navigation(
        startDestination = Screen.MainScreen.route ,
        route = Screen.HomeGraph.route ,
    ) {
        composable(Screen.MainScreen.route
        , enterTransition = {
            slideIntoContainer(
                AnimatedContentTransitionScope.SlideDirection.Right ,
                animationSpec = tween(1500),
                initialOffset = { it }
            )
        }
            , exitTransition = {
                slideOutOfContainer(
                    AnimatedContentTransitionScope.SlideDirection.Left ,
                    animationSpec = tween(1500)
                )
            },
            popEnterTransition = {
                slideIntoContainer(
                    AnimatedContentTransitionScope.SlideDirection.Left ,
                    animationSpec = tween(1500)
                )
            }
        ) {
            HomeScreen(navController)
        }
        composable(
            Screen.Chats.route

        ) {
            MainChatRoomFun(navController)
        }
        composable(Screen.Status.route) {
            StatusScreen(navController)
        }
        composable(Screen.Channels.route) {
            ChannelsScreen(navController)

        }
        composable(Screen.Error.route) {
            ErrorScreen(navController , "Error: Unknown route")
        }
    }
}