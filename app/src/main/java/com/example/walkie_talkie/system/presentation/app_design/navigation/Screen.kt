package com.example.walkie_talkie.system.presentation.app_design.navigation


sealed class Screen(val route: String) {

    // page routes
    data object MainScreen : Screen("main_screen")
    data object Chats : Screen("chats")
    data object Channels : Screen("groups")
    data object Status : Screen("stories")
    data object Ai : Screen("ai")
    data object Fav : Screen("favorite")
    data object Arch : Screen("archive")
    data object Settings : Screen("search")
    data object LockedChats : Screen("locked_chats")
    data object Thames : Screen("thames")
    data object Privacy : Screen("privacy")
    data object Notifications : Screen("notifications")
    data object Updates : Screen("updates")
    data object Help : Screen("help")
    data object AiSetting : Screen("ai_setting")
    data object Error : Screen("error")
    data object Login : Screen("login")
    data object Signin : Screen("signup")
    data object ForgotPassword : Screen("forgot_password")
    data object Verification : Screen("verification")
    data object Welcome : Screen("welcome")
    data object Splash : Screen("splash")


    // groups routes
    data object HomeGraph : Screen("home_gram")
    data object SettingsGraph : Screen("settings_graph")
    data object MenuGraph : Screen("menu")
    data object AuthGraph : Screen("authentication")
    data object AIGraph : Screen("chat")
    //  data object Friends : Screen("friends")



}

