package com.example.walkie_talkie.system.presentation.app_design.ui.screens.authaintcation.welcome

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.walkie_talkie.theme.darkBlue
import com.example.walkie_talkie.theme.darkBlue2

@RequiresApi(Build.VERSION_CODES.S)
@Composable
fun WelcomeMainFun(navController: NavController) {

    val pageState = rememberPagerState { 4 }
    var index = remember { mutableIntStateOf(pageState.currentPage) }
    val incrment = {
        index.value++
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally ,
        verticalArrangement = Arrangement.Top ,
        modifier = Modifier
            .fillMaxSize()
            .background(darkBlue2) ,
    ) {

        AuthStatusBarRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp) ,
            darkBlue
        )

        Spacer(modifier = Modifier.height(200.dp))

        Box(
            modifier = Modifier
                .width(398.dp)
                .height(658.dp)
                .background(darkBlue)
                .clip(shape = RoundedCornerShape(24.dp)) ,
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(shape = RoundedCornerShape(24.dp))
            ) {
                HorizontalPager(
                    state = pageState ,
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(shape = RoundedCornerShape(24.dp)) ,

                    ) { page ->
                    when (page) {
                        0 -> WelcomeScreen1(index , incrment)
                        1 -> WelcomeScreen2(index , incrment)
                        2 -> WelcomeScreen3(index , incrment)
                        3 -> WelcomeScreen4(index , incrment)


                    }
                }
            }

        }
    }
}