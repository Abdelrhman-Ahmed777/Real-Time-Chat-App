package com.example.walkie_talkie.system.presentation.app_design.ui.screens.authaintcation.singin

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.walkie_talkie.R.drawable.email_ic
import com.example.walkie_talkie.R.drawable.password_ic
import com.example.walkie_talkie.R.drawable.phone_ic
import com.example.walkie_talkie.system.presentation.app_design.ui.screens.authaintcation.EnterMessage
import com.example.walkie_talkie.theme.darkBlue
import com.example.walkie_talkie.theme.lightBlue
import com.example.walkie_talkie.ui_thames.theme.digital

@Composable
fun SighnInScreen1() {
    Box(
        modifier = Modifier
            .width(350.dp)
            .height(550.dp)
    ) {
        ConstraintLayout() {
            val (enterPhone , enterEmail , phone , password , emial , text2 , reWrite , reWritePass) = createRefs()


            Text(
                text = "Email" ,
                modifier = Modifier
                    .constrainAs(emial) {
                        top.linkTo(parent.top , margin = 32.dp)
                        start.linkTo(parent.start , margin = 48.dp)
                    } ,
                fontSize = 24.sp ,
                fontFamily = digital ,
                color = lightBlue

            )

            EnterMessage(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 16.dp , start = 16.dp)
                    .wrapContentHeight()
                    .clip(RoundedCornerShape(15.dp))
                    .background(darkBlue)
                    .constrainAs(enterEmail) {
                        top.linkTo(emial.bottom , margin = 16.dp)
                        start.linkTo(parent.start , margin = 32.dp)
                        end.linkTo(parent.end , margin = 32.dp)

                    } ,
                "Email" ,
                email_ic ,

                )
            Text(
                text = "phone number" ,
                modifier = Modifier
                    .constrainAs(phone) {
                        top.linkTo(enterEmail.bottom , margin = 32.dp)
                        start.linkTo(parent.start , margin = 48.dp)
                    } ,
                fontSize = 24.sp ,
                fontFamily = digital ,
                color = lightBlue

            )

            EnterMessage(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 16.dp , start = 16.dp)
                    .wrapContentHeight()
                    .clip(RoundedCornerShape(15.dp))
                    .background(darkBlue)
                    .constrainAs(enterPhone) {
                        top.linkTo(phone.bottom , margin = 16.dp)
                        start.linkTo(parent.start , margin = 32.dp)
                        end.linkTo(parent.end , margin = 32.dp)

                    } ,
                "phone number" ,
                phone_ic ,
            )


            Text(
                text = "password" ,
                modifier = Modifier
                    .constrainAs(text2) {
                        top.linkTo(enterPhone.bottom , margin = 32.dp)
                        start.linkTo(parent.start , margin = 48.dp)
                    } ,
                fontSize = 24.sp ,
                fontFamily = digital ,
                color = lightBlue
            )

            EnterMessage(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 16.dp , start = 16.dp)
                    .wrapContentHeight()
                    .clip(RoundedCornerShape(15.dp))
                    .background(darkBlue)
                    .constrainAs(password) {
                        top.linkTo(text2.bottom , margin = 8.dp)
                        start.linkTo(parent.start , margin = 32.dp)
                        end.linkTo(parent.end , margin = 32.dp)

                    } ,
                "password" ,
                password_ic
            )
            Text(
                text = "re-wirte the password" ,
                modifier = Modifier
                    .constrainAs(reWrite) {
                        top.linkTo(password.bottom , margin = 32.dp)
                        start.linkTo(parent.start , margin = 48.dp)
                    } ,
                fontSize = 24.sp ,
                fontFamily = digital ,
                color = lightBlue
            )

            EnterMessage(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 16.dp , start = 16.dp)
                    .wrapContentHeight()
                    .clip(RoundedCornerShape(15.dp))
                    .background(darkBlue)
                    .constrainAs(reWritePass) {
                        top.linkTo(reWrite.bottom , margin = 8.dp)
                        start.linkTo(parent.start , margin = 32.dp)
                        end.linkTo(parent.end , margin = 32.dp)

                    } ,
                "re-write the password" ,
                password_ic
            )


        }
    }
}