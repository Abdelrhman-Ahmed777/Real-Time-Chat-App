package com.example.walkie_talkie.system.presentation.app_design.ui.screens.authaintcation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.walkie_talkie.theme.darkBlue2
import com.example.walkie_talkie.theme.darkBlue3

@Preview
@Composable
fun FristScreen() {

    var selectedTabIndex by remember {
        mutableIntStateOf(0)
    }

    val pageState = rememberPagerState { 3 }
    LaunchedEffect(selectedTabIndex) {
        if (pageState.currentPage != selectedTabIndex) {
            pageState.animateScrollToPage(selectedTabIndex)
        }
    }


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(darkBlue2)
    )
    {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()

        ) {
            val (content ) = createRefs()

            HorizontalPager(
                state = pageState,
                modifier = Modifier

                    .constrainAs(content) {
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }){

            }

        }
    }
}
