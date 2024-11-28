package com.example.walkie_talkie.system.presentation.app_design.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost


// the navigation graph
@RequiresApi(Build.VERSION_CODES.S)
@Composable
fun NestedNavigationGraph(navController: NavHostController , isLoggedIn: Boolean) {

    NavHost(
        navController = navController ,
        startDestination = if (isLoggedIn) Screen.HomeGraph.route else Screen.AuthGraph.route
    ) {
        home(navController = navController)
        menu(navController = navController)
        aiScreen(navController = navController)
        Settings(navController = navController)
        auth(navController = navController)
        //   Friends(navController = navController)

    }

}



