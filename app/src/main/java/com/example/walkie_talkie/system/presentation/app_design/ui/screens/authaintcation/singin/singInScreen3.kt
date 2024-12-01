package com.example.walkie_talkie.system.presentation.app_design.ui.screens.authaintcation.singin

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.walkie_talkie.R
import com.example.walkie_talkie.R.drawable.acount_name_ic
import com.example.walkie_talkie.R.drawable.male_profile
import com.example.walkie_talkie.system.presentation.app_design.ui.screens.authaintcation.EnterMessage
import com.example.walkie_talkie.system.presentation.app_design.ui.screens.authaintcation.bio
import com.example.walkie_talkie.theme.darkBlue
import com.example.walkie_talkie.theme.darkBlue3
import com.example.walkie_talkie.theme.lightBlue
import com.example.walkie_talkie.theme.white
import com.example.walkie_talkie.ui_thames.theme.digital

@Preview
@Composable
fun SignInScreen3() {


    var isMale by remember { mutableStateOf(false) }
    var isFemale by remember { mutableStateOf(false) }



    ConstraintLayout(
        modifier = Modifier.fillMaxSize()
    ) {
        val (image , button , male , female , name , enterName , bio , enterBio) = createRefs()



        Column(
            horizontalAlignment = Alignment.CenterHorizontally ,
            modifier = Modifier
                .width(150.dp)
                .height(200.dp)
                .clip(RoundedCornerShape(10.dp))
                .padding(16.dp)
                .constrainAs(male) {
                    start.linkTo(parent.start , margin = 32.dp)
                    top.linkTo(parent.top , margin = 8.dp)
                }
                .clickable {
                    isMale = true
                    isFemale = false
                    //    isMaleValue(isMale)
                    //   isFemaleValue(isFemale)
                }
                .border(
                    width = 2.dp ,
                    color = if (isMale) white else darkBlue ,
                    shape = RoundedCornerShape(10.dp)
                )
        ) {
            Image(
                painter = painterResource(id = male_profile) ,
                contentDescription = null ,
                modifier = Modifier
                    .size(100.dp)
                    .padding(horizontal = 16.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .clickable {
                        isMale = true
                        isFemale = false
                        //     isMaleValue(isMale)
                        //     isFemaleValue(isFemale)
                    }

            )
            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "male" ,
                fontSize = 24.sp ,
                fontFamily = digital ,
                color = lightBlue ,
                modifier = Modifier
                    .weight(1F)
                    .padding(bottom = 8.dp)
                    .clickable {
                        isMale = true
                        isFemale = false
                        //    isMaleValue(isMale)
                        //     isFemaleValue(isFemale)
                    }
            )
        }



        Column(
            horizontalAlignment = Alignment.CenterHorizontally ,
            modifier = Modifier
                .width(150.dp)
                .height(200.dp)
                .clip(RoundedCornerShape(10.dp))
                .padding(16.dp)
                .constrainAs(female) {
                    end.linkTo(parent.end , margin = 32.dp)
                    top.linkTo(parent.top , margin = 8.dp)
                }
                .clickable {
                    isMale = false
                    isFemale = true
                    //    isMaleValue(isMale)
                    //   isFemaleValue(isFemale)
                }
                .border(
                    width = 2.dp ,
                    color = if (isFemale) white else darkBlue ,
                    shape = RoundedCornerShape(10.dp)
                )
        ) {
            Image(
                painter = painterResource(id = R.drawable.female) ,
                contentDescription = null ,
                modifier = Modifier
                    .size(100.dp)
                    .padding(horizontal = 16.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .clickable {
                        isMale = false
                        isFemale = true
                        //     isMaleValue(isMale)
                        //     isFemaleValue(isFemale)
                    }

            )
            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "female" ,
                fontSize = 24.sp ,
                fontFamily = digital ,
                color = lightBlue ,
                modifier = Modifier
                    .weight(1F)
                    .padding(bottom = 8.dp)
                    .clickable {
                        isMale = false
                        isFemale = true
                        //    isMaleValue(isMale)
                        //     isFemaleValue(isFemale)
                    }
            )
        }









        Image(
            painter = painterResource(id = if (isMale) male_profile else R.drawable.female) ,
            contentDescription = null ,
            modifier = Modifier
                .size(150.dp)
                .clip(CircleShape)
                .constrainAs(image) {
                    top.linkTo(male.bottom , margin = 32.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                } , contentScale = ContentScale.Crop
        )
        IconButton(
            onClick = { /*TODO*/ } ,
            modifier = Modifier
                .size(40.dp)
                .constrainAs(button) {
                    bottom.linkTo(image.bottom)
                    end.linkTo(image.end)
                } , colors = IconButtonDefaults.iconButtonColors(containerColor = darkBlue3)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.camera_ic) ,
                contentDescription = null ,
                tint = lightBlue
            )
        }


        Text(
            text = "name" ,
            modifier = Modifier
                .constrainAs(name) {
                    top.linkTo(image.bottom , margin = 32.dp)
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
                .constrainAs(enterName) {
                    top.linkTo(name.bottom , margin = 16.dp)
                    start.linkTo(parent.start , margin = 32.dp)
                    end.linkTo(parent.end , margin = 32.dp)

                } ,
            "name" ,
            acount_name_ic ,

            )


        Text(
            text = "About" ,
            modifier = Modifier
                .constrainAs(bio) {
                    top.linkTo(enterName.bottom , margin = 32.dp)
                    start.linkTo(parent.start , margin = 48.dp)
                } ,
            fontSize = 24.sp ,
            fontFamily = digital ,
            color = lightBlue
        )

        bio(
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 16.dp , start = 16.dp)
                .wrapContentHeight()
                .constrainAs(enterBio) {
                    top.linkTo(bio.bottom , margin = 16.dp)
                    start.linkTo(parent.start , margin = 32.dp)
                    end.linkTo(parent.end , margin = 32.dp)

                }
        )

    }
}
