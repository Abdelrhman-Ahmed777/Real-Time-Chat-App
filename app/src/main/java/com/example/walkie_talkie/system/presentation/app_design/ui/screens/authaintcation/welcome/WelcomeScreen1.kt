package com.example.walkie_talkie.system.presentation.app_design.ui.screens.authaintcation.welcome

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.walkie_talkie.R
import com.example.walkie_talkie.R.drawable.auth_lock_ic
import com.example.walkie_talkie.R.drawable.signal_ic
import com.example.walkie_talkie.presentation.screens.screens.authaintcation.DotIndicator
import com.example.walkie_talkie.system.presentation.app_design.ui.componant.woki_toki_screen.status_bar.currentTime
import com.example.walkie_talkie.theme.darkBlue
import com.example.walkie_talkie.theme.lightBlue
import com.example.walkie_talkie.theme.powder
import com.example.walkie_talkie.ui_thames.theme.digital
import kotlinx.coroutines.delay


@RequiresApi(Build.VERSION_CODES.S)
@Composable
fun WelcomeScreen1(index: MutableState<Int> , incrment: () -> Int) {

    Box(
        modifier = Modifier
            .width(398.dp)
            .height(658.dp)
            .background(darkBlue)
            .clip(shape = RoundedCornerShape(24.dp))
    ) {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
                .background(darkBlue)
        ) {
            val (statusBar , title1 , title2 , icon , text1 , text2 , button , indicator) = createRefs()

            AuthStatusBarRow(
                modifier = Modifier.constrainAs(statusBar) {
                    start.linkTo(parent.start , margin = 8.dp)
                    end.linkTo(parent.end , margin = 16.dp)
                    top.linkTo(parent.top , margin = 8.dp)
                } , darkBlue
            )

            Text(
                text = "Welcome \n \n \t \t to " ,
                modifier = Modifier
                    .constrainAs(title1) {
                        top.linkTo(parent.top , margin = 74.dp)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    } ,
                fontSize = 36.sp ,
                fontFamily = digital ,
                color = lightBlue

            )
            Text(
                text = "Walkie Talkie " ,
                modifier = Modifier
                    .constrainAs(title2) {
                        top.linkTo(title1.bottom , margin = 24.dp)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    } ,
                fontSize = 50.sp ,
                fontFamily = digital ,
                color = lightBlue

            )

            Image(
                painter = painterResource(id = auth_lock_ic) ,
                contentDescription = "icon" ,
                modifier = Modifier
                    .constrainAs(icon) {
                        top.linkTo(title2.bottom , margin = 42.dp)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
            )

            Text(
                text = "secure" ,
                modifier = Modifier
                    .constrainAs(text1) {
                        top.linkTo(icon.bottom , margin = 16.dp)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    } ,
                fontSize = 36.sp ,
                fontFamily = digital ,
                color = lightBlue

            )
            Text(
                text = " hacker : ladies and gentleman's \n\t\t\t\t\t\t\t this is not a rubbery" ,
                modifier = Modifier
                    .constrainAs(text2) {
                        top.linkTo(text1.bottom , margin = 16.dp)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    } ,
                fontSize = 22.sp ,
                fontFamily = digital ,
                color = lightBlue
            )
            Button(
                onClick = {
                    incrment()
                } ,
                modifier = Modifier
                    .width(102.dp)
                    .height(54.dp)
                    .constrainAs(button) {
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        top.linkTo(text2.bottom , margin = 24.dp)
                    } ,
                colors = ButtonDefaults.buttonColors(
                    containerColor = powder ,
                )
            ) {
                Text(
                    text = "Next" ,
                    fontSize = 27.sp ,
                    fontFamily = digital ,
                    color = lightBlue
                )
            }

            DotIndicator(
                totalDots = 4 ,
                selectedIndex = index.value ,
                selectedColor = lightBlue ,
                unselectedColor = Color.Gray ,
                dotSize = 8.dp ,
                dotSpacing = 40.dp ,
                modifier = Modifier
                    .constrainAs(indicator) {
                        top.linkTo(button.bottom , margin = 32.dp)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    } ,
            )
        }
    }
}

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
