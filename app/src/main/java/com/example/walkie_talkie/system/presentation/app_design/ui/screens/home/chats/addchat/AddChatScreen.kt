package com.example.walkie_talkie.system.presentation.app_design.ui.screens.home.chats.addchat

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.walkie_talkie.R.drawable.back_ic
import com.example.walkie_talkie.R.drawable.male_profile
import com.example.walkie_talkie.ui_thames.DarkColorScheme.black
import com.example.walkie_talkie.ui_thames.DarkColorScheme.darkBlue2
import com.example.walkie_talkie.ui_thames.DarkColorScheme.lightBlue
import com.example.walkie_talkie.ui_thames.DarkColorScheme.midPurple
import com.example.walkie_talkie.ui_thames.theme.digital

@Preview(showBackground = true)
@Composable
fun AddContact() {
    val background: Brush = Brush.verticalGradient(
        colors = listOf(
            black ,
            black ,
            darkBlue2 ,
            midPurple ,
            lightBlue
        )
    )
    Box(
        modifier = Modifier
            .background(background)
            .fillMaxSize()
    ) {

        ConstraintLayout(Modifier.fillMaxSize()) {
            val (title , itemes , backButton) = createRefs()
            Icon(
                imageVector = ImageVector.vectorResource(id = back_ic) ,
                contentDescription = "Back" ,
                tint = lightBlue ,
                modifier = Modifier
                    .size(24.dp)
                    .constrainAs(backButton) {
                        top.linkTo(parent.top , margin = 32.dp)
                        start.linkTo(parent.start , margin = 24.dp)

                    }
                    .clickable { }
            )
            Text(
                text = "Select a chat to start message..." ,
                color = lightBlue ,
                fontFamily = digital ,
                fontSize = 23.sp ,
                modifier = Modifier.constrainAs(title) {
                    top.linkTo(parent.top , margin = 32.dp)
                    start.linkTo(backButton.end , margin = 8.dp)
                    end.linkTo(parent.end , margin = 16.dp)
                }
            )

            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .constrainAs(itemes) {
                        top.linkTo(title.bottom , margin = 16.dp)
                        start.linkTo(parent.start , margin = 16.dp)
                        end.linkTo(parent.end , margin = 16.dp)
                        //           bottom.linkTo(parent.bottom, margin = 16.dp)
                    }
            ) { }

        }

    }
}


@Preview(showBackground = true)
@Composable
fun AddContactItem() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(106.dp)
            .padding(16.dp)
            .clickable { } , shape = RoundedCornerShape(10.dp)
    ) {
        ConstraintLayout(Modifier.fillMaxSize()) {
            val (image , name , bio) = createRefs()

            Image(
                imageVector = ImageVector.vectorResource(id = male_profile) ,
                contentDescription = "Back" ,
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape)
                    .constrainAs(image) {
                        top.linkTo(parent.top , margin = 16.dp)
                        start.linkTo(parent.start , margin = 16.dp)
                    }
            )
        }

// u need to complete this part
    }
}


