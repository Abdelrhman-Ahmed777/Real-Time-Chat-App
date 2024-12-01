package com.example.walkie_talkie.system.presentation.app_design.ui.screens.authaintcation.welcome

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerDefaults
import androidx.compose.foundation.pager.PagerSnapDistance
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.example.walkie_talkie.presentation.screens.screens.authaintcation.DotIndicator
import com.example.walkie_talkie.system.presentation.app_design.navigation.Screen
import com.example.walkie_talkie.theme.darkBlue
import com.example.walkie_talkie.theme.darkBlue2
import com.example.walkie_talkie.theme.lightBlue
import com.example.walkie_talkie.theme.powder
import com.example.walkie_talkie.ui_thames.theme.digital
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@RequiresApi(Build.VERSION_CODES.S)
@Composable
fun WelcomeMainFun(navController: NavController) {

    val pageState = rememberPagerState(
        initialPage = 0 ,
        pageCount = { 4 })
    val smootherAnimSpec = tween<Float>(durationMillis = 500)
    val index = remember { mutableIntStateOf(pageState.currentPage) }
    val coroutineScope = rememberCoroutineScope()
    val increment: () -> Unit = {
        ((index.intValue + 1) % 4).also { index.intValue = it }
        coroutineScope.launch {
            pageState.run { animateScrollToPage(index.intValue , animationSpec = smootherAnimSpec) }
        }
    }
    LaunchedEffect(pageState.currentPage , pageState.isScrollInProgress) {
        if (!pageState.isScrollInProgress) {
            pageState.currentPage.also { index.intValue = it }
        }
    }

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(darkBlue2)
    ) {


        val (indicator , statusBar , pages , buttons) = createRefs()


        AuthStatusBarRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .constrainAs(statusBar) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(parent.top)
                } ,
            darkBlue
        )



        HorizontalPager(
            state = pageState ,
            flingBehavior = PagerDefaults.flingBehavior(
                state = pageState ,
                pagerSnapDistance = PagerSnapDistance.atMost(4)
            ) ,
            modifier = Modifier
                .wrapContentWidth()
                .height(658.dp)
                .padding(horizontal = 16.dp)
                .constrainAs(pages) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(statusBar.bottom , margin = 32.dp)
                }
                .clip(shape = RoundedCornerShape(24.dp))

        ) {
            when (it) {
                0 -> WelcomeScreen1()
                1 -> WelcomeScreen2()
                2 -> WelcomeScreen3()
                3 -> WelcomeScreen4()
            }
        }




        DotIndicator(
            totalDots = 4 ,
            selectedIndex = index.intValue ,
            selectedColor = lightBlue ,
            unselectedColor = Color.Gray ,
            dotSize = 8.dp ,
            dotSpacing = 40.dp ,
            modifier = Modifier
                .constrainAs(indicator) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(buttons.top , margin = 32.dp)
                })

        Button(
            onClick = {
                if (pageState.currentPage != 3) {
                    coroutineScope.launch(Dispatchers.IO) {
                        increment()
                    }
                } else {
                    navController.navigate(Screen.Login.route)
                }
            } ,
            modifier = Modifier
                .wrapContentWidth()
                .height(54.dp)
                .constrainAs(buttons) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom , margin = 32.dp)
                } ,
            colors = ButtonDefaults.buttonColors(
                containerColor = powder ,
            )
        ) {
            Text(
                text =
                when (pageState.currentPage) {
                    0 -> "Next"
                    1 -> "Next"
                    2 -> "Next"
                    3 -> "Get Started"
                    else -> ""
                } ,
                fontSize = 27.sp ,
                fontFamily = digital ,
                color = lightBlue
            )
        }

    }
}


