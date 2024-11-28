package com.example.walkie_talkie.system.presentation.app_design.ui.screens.authaintcation.singin

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.walkie_talkie.R
import com.example.walkie_talkie.theme.lightBlue
import com.example.walkie_talkie.ui_thames.theme.digital

@Composable
fun SighnInScreen2() {
    Box(
        modifier = Modifier
            .width(350.dp)
            .height(550.dp)
    ) {
        ConstraintLayout(
            modifier = Modifier.fillMaxSize()
        ) {
            val (gender , male , maleText , female , femaleText) = createRefs()


            Text(
                text = "chose your gender :" ,
                modifier = Modifier
                    .constrainAs(gender) {
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        top.linkTo(parent.top , margin = 32.dp)
                    } ,
                fontSize = 24.sp ,
                fontFamily = digital ,
                color = lightBlue)


            Image(
                painter = painterResource(id = R.drawable.male_profile) ,
                contentDescription = null ,
                modifier = Modifier
                    .size(100.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .clickable {

                    }
                    .constrainAs(male) {
                        start.linkTo(parent.start , margin = 32.dp)
                        top.linkTo(gender.bottom , margin = 72.dp)
                    }
            )

            Text(
                text = "male" ,
                fontSize = 24.sp ,
                fontFamily = digital ,
                color = lightBlue ,
                modifier = Modifier
                    .constrainAs(maleText) {
                        start.linkTo(male.end , margin = 16.dp)
                        top.linkTo(male.top , 48.dp)
                    }
            )


            Image(
                painter = painterResource(id = R.drawable.female) ,
                contentDescription = null ,
                modifier = Modifier
                    .size(100.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .clickable {

                    }
                    .constrainAs(female) {
                        start.linkTo(parent.start , margin = 32.dp)
                        top.linkTo(male.bottom , margin = 32.dp)
                    }
            )

            Text(
                text = "female" ,
                fontSize = 24.sp ,
                fontFamily = digital ,
                color = lightBlue ,
                modifier = Modifier
                    .constrainAs(femaleText) {
                        start.linkTo(male.end , margin = 16.dp)
                        top.linkTo(male.bottom , 72.dp)
                    }
            )


        }
    }
}