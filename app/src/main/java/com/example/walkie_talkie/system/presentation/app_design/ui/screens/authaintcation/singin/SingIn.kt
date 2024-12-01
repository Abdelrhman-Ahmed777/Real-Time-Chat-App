package com.example.walkie_talkie.system.presentation.app_design.ui.screens.authaintcation.singin

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.example.walkie_talkie.R.drawable.back_ic
import com.example.walkie_talkie.presentation.screens.screens.authaintcation.DotIndicator
import com.example.walkie_talkie.system.domain.app_design.entities.User
import com.example.walkie_talkie.system.presentation.app_design.navigation.Screen
import com.example.walkie_talkie.system.presentation.app_design.ui.screens.authaintcation.welcome.AuthStatusBarRow
import com.example.walkie_talkie.theme.darkBlue
import com.example.walkie_talkie.theme.darkBlue3
import com.example.walkie_talkie.theme.lightBlue
import com.example.walkie_talkie.theme.powder
import com.example.walkie_talkie.ui_thames.theme.digital
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun SignIn(navController: NavController) {


    val name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    val about by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val reWritePassword by remember { mutableStateOf("") }
    var phoneNumber by remember { mutableStateOf("") }
    var isMale by remember { mutableStateOf(false) }
    var isFemale by remember { mutableStateOf(false) }


    val pageState = rememberPagerState { 2 }
    var index by remember { mutableIntStateOf(pageState.currentPage) }
    val coroutineScope = rememberCoroutineScope()
    val increment: () -> Unit = {
        ((index + 1) % 3).also { index = it }
        coroutineScope.launch {
            pageState.run { animateScrollToPage(index , animationSpec = spring()) }
        }
    }
    val decrement: () -> Unit = {
        ((index - 1) % 3).also { index = it }
        coroutineScope.launch {
            pageState.run { animateScrollToPage(index , animationSpec = spring()) }
        }
    }
    LaunchedEffect(pageState.currentPage , pageState.isScrollInProgress) {
        if (!pageState.isScrollInProgress) {
            pageState.run { animateScrollToPage(index , animationSpec = spring()) }
        }
    }


    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxSize()
            .background(darkBlue)
    ) {
        val (back , statusBar , dots , title , screens , nextButton , prevButton) = createRefs()

        AuthStatusBarRow(

            modifier = Modifier.constrainAs(statusBar) {
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                top.linkTo(parent.top , margin = 8.dp)
            } , darkBlue3
        )



        Icon(
            imageVector = ImageVector.vectorResource(id = back_ic) ,
            contentDescription = null ,
            tint = lightBlue ,
            modifier = Modifier
                .clickable {
                    navController.popBackStack()
                }
                .size(40.dp)
                .constrainAs(back) {
                    start.linkTo(parent.start , margin = 24.dp)
                    top.linkTo(parent.top , margin = 70.dp)
                }
        )

        Text(
            text = "sing in" ,
            modifier = Modifier
                .constrainAs(title) {
                    top.linkTo(parent.top , margin = 64.dp)
                    start.linkTo(back.end , margin = 16.dp)
                } ,
            fontSize = 50.sp ,
            fontFamily = digital ,
            color = lightBlue

        )


        HorizontalPager(
            state = pageState ,
            contentPadding = PaddingValues(8.dp) ,
            modifier = Modifier
                .constrainAs(screens) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(title.bottom , 24.dp)
                }
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            when (pageState.currentPage) {
                0 -> SignInScreen1(setEmailValue = { email = it } ,
                    setPhoneNumberValue = { phoneNumber = it } ,
                    setPasswordValue = { password = it } ,
                    setReWritePassword = { password = it })

                1 -> SignInScreen3()
            }
        }

        if (index != 1) {
            Text(
                text = "next" ,
                modifier = Modifier
                    .clickable {
                        increment()

                    }
                    .constrainAs(nextButton) {
                        end.linkTo(parent.end , margin = 24.dp)
                        bottom.linkTo(parent.bottom , margin = 24.dp)
                    } ,
                fontSize = 32.sp ,
                fontFamily = digital ,
                color = lightBlue
            )
        } else {
            Button(
                onClick = {
                    coroutineScope.launch(Dispatchers.IO) {
                        try {
                            User(
                                username = name ,
                                about = about ,
                                email = email ,
                                password = password ,
                                phoneNumber = phoneNumber ,
                                isMale = isMale ,
                            )
                            Log.d(
                                "signIn" ,
                                "user: name :$name , email :$email , password : $password ,phone : $phoneNumber "
                            )
                        } catch (e: Exception) {
                            Log.d("signIn" , "user: $e")
                        }
                    }
                    navController.navigate(Screen.HomeGraph.route)
                } ,
                Modifier
                    .wrapContentSize()
                    .clip(RoundedCornerShape(24.dp))
                    .constrainAs(nextButton) {
                        end.linkTo(parent.end , margin = 24.dp)
                        bottom.linkTo(parent.bottom , margin = 24.dp)
                    } , colors = ButtonDefaults.buttonColors(containerColor = powder)
            ) {
                Text(
                    text = "done" , fontSize = 30.sp , fontFamily = digital , color = lightBlue

                )
            }
        }


        Text(
            text = "back" ,
            modifier = Modifier
                .clickable {
                    decrement()
                }
                .constrainAs(prevButton) {
                    start.linkTo(parent.start , margin = 24.dp)
                    bottom.linkTo(parent.bottom , margin = 24.dp)
                } ,
            fontSize = 32.sp ,
            fontFamily = digital ,
            color = lightBlue
        )


        DotIndicator(
            totalDots = 2 ,
            selectedIndex = index ,
            selectedColor = lightBlue ,
            unselectedColor = Color.Gray ,
            dotSize = 8.dp ,
            dotSpacing = 32.dp ,
            modifier = Modifier.constrainAs(dots) {
                bottom.linkTo(parent.bottom , margin = 32.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }


        )
    }
}









