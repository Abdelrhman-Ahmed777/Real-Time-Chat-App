package com.example.walkie_talkie.system.presentation.app_design.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost


// the navigation graph
@RequiresApi(Build.VERSION_CODES.S)
@Composable
fun NestedNavigationGraph(navController: NavHostController , isLoggedIn: MutableState<Boolean>) {

    NavHost(
        navController = navController ,
        startDestination = if (isLoggedIn.value) {
            Screen.HomeGraph.route
        } else Screen.AuthGraph.route,

    ) {
        home(navController = navController)
        menu(navController = navController)
        aiScreen(navController = navController)
        Settings(navController = navController)
        auth(navController = navController)
        //   Friends(navController = navController)

    }

}



