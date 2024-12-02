package com.example.walkie_talkie.system

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.compose.rememberNavController
import com.example.walkie_talkie.system.presentation.app_design.navigation.NestedNavigationGraph

@RequiresApi(Build.VERSION_CODES.S)
@Composable
fun MyApp() {
    val navController = rememberNavController()
    val isLoggedIn = remember { mutableStateOf(false) }
    NestedNavigationGraph(
        navController = navController ,
        isLoggedIn = isLoggedIn
    )
}