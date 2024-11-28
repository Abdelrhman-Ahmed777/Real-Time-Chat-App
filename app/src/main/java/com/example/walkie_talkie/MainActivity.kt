package com.example.walkie_talkie

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import com.example.walkie_talkie.system.MyApp
import com.example.walkie_talkie.theme.Walkie_TalkieDarkTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint


@androidx.compose.material3.ExperimentalMaterial3Api
class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.S)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Walkie_TalkieDarkTheme {
                val systemUiController = rememberSystemUiController()
                systemUiController.isSystemBarsVisible = false
                MyApp()
            }
        }
    }
}


