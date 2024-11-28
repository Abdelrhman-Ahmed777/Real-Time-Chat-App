package com.example.walkie_talkie.system.presentation.app_design.ui.screens.authaintcation.welcome

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.walkie_talkie.R.drawable.auth_star_ic
import com.example.walkie_talkie.presentation.screens.screens.authaintcation.DotIndicator
import com.example.walkie_talkie.theme.darkBlue
import com.example.walkie_talkie.theme.lightBlue
import com.example.walkie_talkie.theme.powder
import com.example.walkie_talkie.ui_thames.theme.digital


@RequiresApi(Build.VERSION_CODES.S)
@Composable
fun WelcomeScreen4(
    index: MutableState<Int> ,
    incrment: () -> Int
) {
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
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(parent.top , margin = 8.dp)
                } , darkBlue
            )

            Text(
                text = "Welcome \n \t \t to " ,
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
                painter = painterResource(auth_star_ic) ,
                contentDescription = "icon" ,
                modifier = Modifier
                    .constrainAs(icon) {
                        top.linkTo(title2.bottom , margin = 42.dp)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
            )

            Text(
                text = "nice and easy" ,
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
                text = "a little kid can use it" ,
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
                onClick = { incrment() } ,
                modifier = Modifier
                    .wrapContentWidth()
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
                    text = "lets get started" ,
                    fontSize = 27.sp ,
                    fontFamily = digital ,
                    color = lightBlue
                )
            }
            DotIndicator(
                totalDots = 4 ,
                selectedIndex = 0 ,
                selectedColor = lightBlue ,
                unselectedColor = Color.Gray ,
                dotSize = 8.dp ,
                dotSpacing = 40.dp ,
                modifier = Modifier
                    .constrainAs(indicator) {
                        top.linkTo(button.bottom , margin = 32.dp)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    })
        }
    }
}
