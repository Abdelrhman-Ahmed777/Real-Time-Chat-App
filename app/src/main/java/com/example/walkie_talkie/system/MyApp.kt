package com.example.walkie_talkie.system

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.walkie_talkie.system.presentation.app_design.navigation.NestedNavigationGraph

@RequiresApi(Build.VERSION_CODES.S)
@Composable
fun MyApp(){
    val navController = rememberNavController()
    val isLoggedIn = false
NestedNavigationGraph(
    navController = navController,
    isLoggedIn = isLoggedIn
)
}