package com.example.walkie_talkie.system.presentation.app_design.ui.screens.ai.ai_chat_room

import android.util.Log
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imeNestedScroll
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.example.walkie_talkie.R
import com.example.walkie_talkie.system.data.app_design.feature_ai_chat.repository.Connection
import com.example.walkie_talkie.system.data.app_design.feature_ai_chat.repository.NetworkState
import com.example.walkie_talkie.system.presentation.app_design.ui.componant.woki_toki_screen.status_bar.StatusBar
import com.example.walkie_talkie.theme.darkBlue
import com.example.walkie_talkie.theme.darkBlue2
import com.example.walkie_talkie.theme.lightBlue
import com.example.walkie_talkie.ui_thames.theme.digital

@OptIn(ExperimentalLayoutApi::class)
@Composable

fun AiChatWikiTokiScreen(navController: NavController) {

    val connectivityObserver = Connection(LocalContext.current.applicationContext)
    val isConnected by connectivityObserver.observe()
        .collectAsState(initial = NetworkState.Unavailable)


    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(124.dp)
            .background(darkBlue)
            .imeNestedScroll() ,
    ) {
        ConstraintLayout(modifier = Modifier.fillMaxSize()) {
            val (statusBar , about , backIcon , userProfile , name , typing , online , moreIcon) = createRefs()

            StatusBar(
                modifier = Modifier.constrainAs(statusBar) {
                    top.linkTo(parent.top , margin = 10.dp)
                    start.linkTo(parent.start , margin = 8.dp)
                    end.linkTo(parent.end , margin = 8.dp)
                } ,
                backGround = darkBlue
            )
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.back_ic) ,
                contentDescription = null ,
                modifier = Modifier
                    .constrainAs(backIcon) {
                        top.linkTo(statusBar.bottom , margin = 32.dp)
                        start.linkTo(parent.start , margin = 16.dp)
                    }
                    .clickable {
                        navController.popBackStack()
                    } , tint = lightBlue

            )


            Image(
                painter = painterResource(id = R.drawable.robot_profile) ,
                contentDescription = "user profile" ,
                modifier = Modifier
                    .clip(CircleShape)
                    .size(60.dp)
                    .aspectRatio(1f)
                    .constrainAs(userProfile) {
                        top.linkTo(statusBar.bottom , margin = 16.dp)
                        start.linkTo(backIcon.end , margin = 16.dp)
                    }
            )

            Text(
                text = "gemini" ,
                color = lightBlue ,
                fontFamily = digital ,
                fontSize = 24.sp ,
                modifier = Modifier.constrainAs(name) {
                    top.linkTo(statusBar.bottom , margin = 32.dp)
                    start.linkTo(userProfile.end , margin = 16.dp)
                } ,
            )

            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.seen_ic) ,
                contentDescription = null ,
                tint = if (isConnected == NetworkState.Available) Green else Red ,
                modifier = Modifier
                    .border(1.dp , lightBlue , CircleShape)
                    .clickable {
                        Log.d(
                            "connection" ,
                            "ChatWikiTokiScreen: $isConnected /n the value of isConnected is :$isConnected"
                        )
                    }
                    .constrainAs(online) {
                        top.linkTo(statusBar.bottom , margin = 16.dp)
                        end.linkTo(parent.end , margin = 24.dp)
                    }
            )

        }
    }
}

@Composable
fun ChatWikiTokiScreen(navController: NavController) {

    val connectivityObserver = Connection(LocalContext.current.applicationContext)
    val isConnected by connectivityObserver.observe()
        .collectAsState(initial = NetworkState.Unavailable)
    var isExpanded by remember { mutableStateOf(false) }
    val configuration = LocalConfiguration.current
    val maxHeight = configuration.screenHeightDp.dp
    val height by animateDpAsState(
        targetValue = if (isExpanded) maxHeight else 124.dp ,
        animationSpec = tween(durationMillis = 300) , label = ""
    )
    val imageSize by animateDpAsState(
        targetValue = if (isExpanded) 164.dp else 60.dp ,
        animationSpec = tween(durationMillis = 300) , label = "" // Adjust duration as needed
    )

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(height)
            .background(darkBlue)
    ) {
        ConstraintLayout(modifier = Modifier.fillMaxSize()) {
            val (statusBar , about , backIcon , userProfile , name , typing , online , moreIcon) = createRefs()

            StatusBar(
                modifier = Modifier.constrainAs(statusBar) {
                    top.linkTo(parent.top , margin = 10.dp)
                    start.linkTo(parent.start , margin = 8.dp)
                    end.linkTo(parent.end , margin = 8.dp)
                } ,
                backGround = darkBlue
            )
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.back_ic) ,
                contentDescription = null ,
                modifier = Modifier
                    .constrainAs(backIcon) {
                        top.linkTo(statusBar.bottom , margin = 32.dp)
                        start.linkTo(parent.start , margin = 16.dp)
                    }
                    .clickable {
                        navController.popBackStack()
                    } , tint = lightBlue

            )


            Image(
                painter = painterResource(id = R.drawable.robot_profile) ,
                contentDescription = "user profile" ,
                modifier = Modifier
                    .clip(CircleShape)
                    .size(imageSize)
                    .aspectRatio(1f)
                    .clickable {
                        isExpanded = !isExpanded
                    }
                    .constrainAs(userProfile) {
                        top.linkTo(statusBar.bottom , margin = if (isExpanded) 64.dp else 16.dp)
                        if (isExpanded) {
                            end.linkTo(parent.end)
                            start.linkTo(parent.start)
                        }
                        start.linkTo(backIcon.end , margin = 16.dp)
                    }
            )

            if (isExpanded) {
                Text(
                    text = "gemini" ,
                    color = lightBlue ,
                    fontFamily = digital ,
                    fontSize = 34.sp ,
                    modifier = Modifier.constrainAs(name) {
                        top.linkTo(userProfile.bottom , margin = 32.dp)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    } ,
                )

                Box(modifier = Modifier
                    .width(300.dp)
                    .wrapContentHeight()
                    .background(darkBlue2)
                    .clip(RoundedCornerShape(16.dp))
                    .border(
                        2.dp , lightBlue , RoundedCornerShape(16.dp)
                    )
                    .constrainAs(about) {
                        top.linkTo(name.bottom , margin = 32.dp)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }) {
                    Text(
                        text = " the about section and this is how it will look like when expanded" ,
                        color = lightBlue ,
                        fontFamily = digital ,
                        fontSize = 24.sp ,
                        modifier = Modifier.padding(16.dp)
                    )
                }


            } else {
                Text(
                    text = "gemini" ,
                    color = lightBlue ,
                    fontFamily = digital ,
                    fontSize = 24.sp ,
                    modifier = Modifier.constrainAs(name) {
                        top.linkTo(statusBar.bottom , margin = 32.dp)
                        start.linkTo(userProfile.end , margin = 16.dp)
                    } ,
                )
            }
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.seen_ic) ,
                contentDescription = null ,
                tint = if (isConnected == NetworkState.Available) Green else Red ,
                modifier = Modifier
                    .border(1.dp , lightBlue , CircleShape)
                    .clickable {
                        Log.d(
                            "connection" ,
                            "ChatWikiTokiScreen: $isConnected /n the value of isConnected is :$isConnected"
                        )
                    }
                    .constrainAs(online) {
                        top.linkTo(statusBar.bottom , margin = 16.dp)
                        end.linkTo(parent.end , margin = 24.dp)
                    }
            )

        }
    }
}
