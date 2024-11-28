package com.example.walkie_talkie.system.presentation.app_design.ui.screens.authaintcation.singin

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.walkie_talkie.R
import com.example.walkie_talkie.R.drawable.acount_name_ic
import com.example.walkie_talkie.R.drawable.back_ic
import com.example.walkie_talkie.R.drawable.email_ic
import com.example.walkie_talkie.R.drawable.password_ic
import com.example.walkie_talkie.R.drawable.phone_ic
import com.example.walkie_talkie.presentation.screens.screens.authaintcation.DotIndicator
import com.example.walkie_talkie.system.presentation.app_design.ui.screens.authaintcation.EnterMessage
import com.example.walkie_talkie.system.presentation.app_design.ui.screens.authaintcation.bio
import com.example.walkie_talkie.system.presentation.app_design.ui.screens.authaintcation.welcome.AuthStatusBarRow
import com.example.walkie_talkie.theme.darkBlue
import com.example.walkie_talkie.theme.darkBlue3
import com.example.walkie_talkie.theme.lightBlue
import com.example.walkie_talkie.theme.powder
import com.example.walkie_talkie.ui_thames.theme.digital


@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
fun SignIn() {

    var index by remember { mutableIntStateOf(2) }


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(darkBlue)
    ) {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
        ) {
            val (back , statusBar , dots , title , screens , enterEmail , nextButton , preevButton , singUpButton) = createRefs()

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

            Box(modifier = Modifier
                .clip(RoundedCornerShape(24.dp))
                .constrainAs(screens) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(title.bottom , margin = 32.dp)
                }
            ) {

                SighnInScreen3()
            }

            if (index != 2) {
                Text(
                    text = "next" ,
                    modifier = Modifier
                        .clickable {
                            index++
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
                    onClick = {} ,
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
                        index--
                    }
                    .constrainAs(preevButton) {
                        start.linkTo(parent.start , margin = 24.dp)
                        bottom.linkTo(parent.bottom , margin = 24.dp)
                    } ,
                fontSize = 32.sp ,
                fontFamily = digital ,
                color = lightBlue
            )


            DotIndicator(
                totalDots = 3 ,
                selectedIndex = index ,
                selectedColor = lightBlue ,
                unselectedColor = Color.Gray ,
                dotSize = 8.dp ,
                dotSpacing = 32.dp ,
                modifier = Modifier.constrainAs(dots) {
                    bottom.linkTo(parent.bottom , margin = 124.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)

                }


            )
        }
    }
}








