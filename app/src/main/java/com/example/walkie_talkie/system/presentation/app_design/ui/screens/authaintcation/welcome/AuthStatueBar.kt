package com.example.walkie_talkie.system.presentation.app_design.ui.screens.authaintcation.welcome

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.walkie_talkie.R
import com.example.walkie_talkie.R.drawable.signal_ic
import com.example.walkie_talkie.system.presentation.app_design.ui.componant.woki_toki_screen.status_bar.currentTime
import com.example.walkie_talkie.theme.lightBlue
import com.example.walkie_talkie.ui_thames.theme.digital
import kotlinx.coroutines.delay

@Composable
fun AuthStatusBarRow(modifier: Modifier , background: Color) {

    var currentTime by remember { mutableStateOf(currentTime()) }
    LaunchedEffect(Unit) {
        while (true) {
            currentTime = currentTime()
            delay(1000)
        }
    }

    Row(
        horizontalArrangement = Arrangement.End ,
        verticalAlignment = Alignment.Top ,
        modifier = modifier
            .fillMaxWidth()
            .height(20.dp)
    ) {
        Text(
            text = currentTime ,
            color = lightBlue ,
            fontSize = 20.sp ,
            fontFamily = digital ,
            modifier = Modifier.padding(start = 24.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Icon(
            imageVector = ImageVector.vectorResource(signal_ic) ,
            contentDescription = null ,
            tint = lightBlue ,
            modifier = Modifier
                .height(20.dp)
                .width(20.dp)

        )
        Spacer(modifier = Modifier.weight(1F))

        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.active_notifications_ic) ,
            contentDescription = null ,
            tint = lightBlue ,
            modifier = Modifier
                .height(20.dp)
                .width(20.dp)

        )
        Spacer(modifier = Modifier.width(8.dp))

        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.cloud_ic) ,
            contentDescription = null ,
            tint = lightBlue ,
            modifier = Modifier
                .height(20.dp)
                .width(20.dp)

        )
        Spacer(modifier = Modifier.width(8.dp))

        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.charging_ic) ,
            contentDescription = null ,
            tint = lightBlue ,
            modifier = Modifier
                .height(20.dp)
                .width(20.dp)

        )
        Spacer(modifier = Modifier.width(8.dp))


    }
}