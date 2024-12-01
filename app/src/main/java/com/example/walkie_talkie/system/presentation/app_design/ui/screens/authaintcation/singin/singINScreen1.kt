package com.example.walkie_talkie.system.presentation.app_design.ui.screens.authaintcation.singin

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.walkie_talkie.R
import com.example.walkie_talkie.R.drawable.email_ic
import com.example.walkie_talkie.R.drawable.password_ic
import com.example.walkie_talkie.R.drawable.phone_ic
import com.example.walkie_talkie.theme.darkBlue
import com.example.walkie_talkie.theme.lightBlue
import com.example.walkie_talkie.ui_thames.theme.digital

@Composable
fun SignInScreen1(
    setEmailValue: (String) -> Unit ,
    setPasswordValue: (String) -> Unit ,
    setReWritePassword: (String) -> Unit ,
    setPhoneNumberValue: (String) -> Unit ,
) {

    var emailValue by remember {
        mutableStateOf("")
    }
    var passwordValue by remember {
        mutableStateOf("")
    }
    var reWritePassword by remember {
        mutableStateOf("")
    }
    var phoneNumberValue by remember {
        mutableStateOf("")
    }


    ConstraintLayout(
        modifier = Modifier.fillMaxSize()
    ) {
        val (enterPhone , enterEmail , phone , password , email , text2 , reWrite , reWritePass) = createRefs()


        Text(
            text = "Email" ,
            modifier = Modifier
                .constrainAs(email) {
                    top.linkTo(parent.top , margin = 32.dp)
                    start.linkTo(parent.start , margin = 48.dp)
                } ,
            fontSize = 24.sp ,
            fontFamily = digital ,
            color = lightBlue

        )


        TextField(value = emailValue ,
            onValueChange = {
                emailValue = it
                setEmailValue(it)
            } ,
            enabled = true ,
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .clip(RoundedCornerShape(50.dp))
                .border(
                    width = 1.dp ,
                    color = lightBlue ,
                    shape = RoundedCornerShape(50.dp)
                )
                .constrainAs(enterEmail) {
                    top.linkTo(email.bottom , margin = 16.dp)
                    start.linkTo(parent.start , margin = 32.dp)
                    end.linkTo(parent.end , margin = 32.dp)

                } ,
            placeholder = {
                Text(text = "Enter your email" , style = TextStyle(color = Color.Gray))
            } ,
            maxLines = 50 ,
            colors = TextFieldDefaults.colors(
                focusedTextColor = lightBlue ,
                unfocusedTextColor = lightBlue ,
                focusedContainerColor = darkBlue ,
                unfocusedContainerColor = darkBlue ,
                focusedIndicatorColor = darkBlue ,
                unfocusedIndicatorColor = darkBlue ,
                cursorColor = lightBlue
            ) ,
            singleLine = true ,

            textStyle = TextStyle(
                color = Color.White ,
                fontSize = 20.sp ,
            ) ,
            leadingIcon = {
                Icon(
                    imageVector = ImageVector.vectorResource(email_ic) ,
                    modifier = Modifier.clickable {
                    } ,
                    contentDescription = null ,
                    tint = lightBlue ,
                )
            } ,
            trailingIcon = {
                if (emailValue.isNotEmpty()) {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = R.drawable.close_ic) ,
                        modifier = Modifier.clickable {
                            emailValue = ""
                        } ,
                        contentDescription = "login" ,
                        tint = Color.Red
                    )
                }
            })





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


        TextField(value = phoneNumberValue ,
            onValueChange = {
                phoneNumberValue = it
                setPhoneNumberValue(it)
            } ,
            enabled = true ,
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .clip(RoundedCornerShape(50.dp))
                .border(
                    width = 1.dp ,
                    color = lightBlue ,
                    shape = RoundedCornerShape(50.dp)
                )
                .constrainAs(enterPhone) {
                    top.linkTo(phone.bottom , margin = 16.dp)
                    start.linkTo(parent.start , margin = 32.dp)
                    end.linkTo(parent.end , margin = 32.dp)

                } ,
            placeholder = {
                Text(text = "Enter your phone number" , style = TextStyle(color = Color.Gray))
            } ,
            maxLines = 50 ,
            colors = TextFieldDefaults.colors(
                focusedTextColor = lightBlue ,
                unfocusedTextColor = lightBlue ,
                focusedContainerColor = darkBlue ,
                unfocusedContainerColor = darkBlue ,
                focusedIndicatorColor = darkBlue ,
                unfocusedIndicatorColor = darkBlue ,
                cursorColor = lightBlue
            ) ,
            singleLine = true ,

            textStyle = TextStyle(
                color = Color.White ,
                fontSize = 20.sp ,
            ) ,
            leadingIcon = {
                Icon(
                    imageVector = ImageVector.vectorResource(phone_ic) ,
                    modifier = Modifier.clickable {
                    } ,
                    contentDescription = null ,
                    tint = lightBlue ,
                )
            } ,
            trailingIcon = {
                if (phoneNumberValue.isNotEmpty()) {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = R.drawable.close_ic) ,
                        modifier = Modifier.clickable {
                            phoneNumberValue = ""
                        } ,
                        contentDescription = "login" ,
                        tint = Color.Red
                    )
                }
            })


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


        TextField(value = passwordValue ,
            onValueChange = {
                passwordValue = it
                setPasswordValue(it)
            } ,
            enabled = true ,
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .clip(RoundedCornerShape(50.dp))
                .border(
                    width = 1.dp ,
                    color = lightBlue ,
                    shape = RoundedCornerShape(50.dp)
                )
                .constrainAs(password) {
                    top.linkTo(text2.bottom , margin = 8.dp)
                    start.linkTo(parent.start , margin = 32.dp)
                    end.linkTo(parent.end , margin = 32.dp)

                } ,
            placeholder = {
                Text(text = "Enter your password" , style = TextStyle(color = Color.Gray))
            } ,
            maxLines = 50 ,
            colors = TextFieldDefaults.colors(
                focusedTextColor = lightBlue ,
                unfocusedTextColor = lightBlue ,
                focusedContainerColor = darkBlue ,
                unfocusedContainerColor = darkBlue ,
                focusedIndicatorColor = darkBlue ,
                unfocusedIndicatorColor = darkBlue ,
                cursorColor = lightBlue
            ) ,
            singleLine = true ,

            textStyle = TextStyle(
                color = Color.White ,
                fontSize = 20.sp ,
            ) ,
            leadingIcon = {
                Icon(
                    imageVector = ImageVector.vectorResource(password_ic) ,
                    modifier = Modifier.clickable {
                    } ,
                    contentDescription = null ,
                    tint = lightBlue ,
                )
            } ,
            trailingIcon = {
                if (passwordValue.isNotEmpty()) {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = R.drawable.close_ic) ,
                        modifier = Modifier.clickable {
                            passwordValue = ""
                        } ,
                        contentDescription = null ,
                        tint = Color.Red
                    )
                }
            })


        Text(
            text = "re-wire the password" ,
            modifier = Modifier
                .constrainAs(reWrite) {
                    top.linkTo(password.bottom , margin = 32.dp)
                    start.linkTo(parent.start , margin = 48.dp)
                } ,
            fontSize = 24.sp ,
            fontFamily = digital ,
            color = lightBlue
        )


        TextField(value = reWritePassword ,
            onValueChange = {
                reWritePassword = it
                setReWritePassword(it)
            } ,
            enabled = true ,
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .clip(RoundedCornerShape(50.dp))
                .border(
                    width = 1.dp ,
                    color = lightBlue ,
                    shape = RoundedCornerShape(50.dp)
                )
                .constrainAs(reWritePass) {
                    top.linkTo(reWrite.bottom , margin = 8.dp)
                    start.linkTo(parent.start , margin = 32.dp)
                    end.linkTo(parent.end , margin = 32.dp)

                } ,
            placeholder = {
                Text(text = "re-write the password" , style = TextStyle(color = Color.Gray))
            } ,
            maxLines = 50 ,
            colors = TextFieldDefaults.colors(
                focusedTextColor = lightBlue ,
                unfocusedTextColor = lightBlue ,
                focusedContainerColor = darkBlue ,
                unfocusedContainerColor = darkBlue ,
                focusedIndicatorColor = darkBlue ,
                unfocusedIndicatorColor = darkBlue ,
                cursorColor = lightBlue
            ) ,
            singleLine = true ,

            textStyle = TextStyle(
                color = Color.White ,
                fontSize = 20.sp ,
            ) ,
            leadingIcon = {
                Icon(
                    imageVector = ImageVector.vectorResource(password_ic) ,
                    modifier = Modifier.clickable {
                    } ,
                    contentDescription = null ,
                    tint = lightBlue ,
                )
            } ,
            trailingIcon = {
                if (reWritePassword.isNotEmpty()) {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = R.drawable.close_ic) ,
                        modifier = Modifier.clickable {
                            reWritePassword = ""
                        } ,
                        contentDescription = "login" ,
                        tint = Color.Red
                    )
                }
            })


    }
}


