package com.example.walkie_talkie.system.presentation.app_design.ui.screens.authaintcation


import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.navigation.NavController
import com.example.walkie_talkie.R
import com.example.walkie_talkie.R.drawable.password_ic
import com.example.walkie_talkie.system.presentation.app_design.navigation.Screen
import com.example.walkie_talkie.system.presentation.app_design.ui.screens.authaintcation.welcome.AuthStatusBarRow
import com.example.walkie_talkie.theme.darkBlue
import com.example.walkie_talkie.theme.lightBlue
import com.example.walkie_talkie.theme.powder
import com.example.walkie_talkie.ui_thames.theme.digital


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun LoginAndSignUp(navController: NavController) {

    var Email by remember { mutableStateOf("") }
    var passwordValue by remember { mutableStateOf("") }



    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(darkBlue)
            .clip(shape = RoundedCornerShape(24.dp))
    ) {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
                .background(darkBlue)
        ) {
            val (statusBar , title , email , password , text1 , text2 , singUpButton , loginButton , text3) = createRefs()

            AuthStatusBarRow(

                modifier = Modifier.constrainAs(statusBar) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(parent.top , margin = 8.dp)
                } , darkBlue
            )


            Text(
                text = "Log in" ,
                modifier = Modifier
                    .constrainAs(title) {
                        top.linkTo(parent.top , margin = 64.dp)
                        start.linkTo(parent.start , margin = 32.dp)
                    } ,
                fontSize = 50.sp ,
                fontFamily = digital ,
                color = lightBlue

            )



            Text(
                text = "Email" ,
                modifier = Modifier
                    .constrainAs(text1) {
                        top.linkTo(title.bottom , margin = 32.dp)
                        start.linkTo(parent.start , margin = 48.dp)
                    } ,
                fontSize = 24.sp ,
                fontFamily = digital ,
                color = lightBlue

            )

            TextField(value = Email ,
                onValueChange = {
                    Email = it
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
                    .constrainAs(email) {
                        top.linkTo(text1.bottom , margin = 16.dp)
                        start.linkTo(parent.start , margin = 32.dp)
                        end.linkTo(parent.end , margin = 32.dp)

                    } ,

                placeholder = {
                    Text(text = "Email" , style = TextStyle(color = Color.Gray))
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
                        imageVector = ImageVector.vectorResource(id = R.drawable.email_ic) ,
                        modifier = Modifier.clickable {
                        } ,
                        contentDescription = null ,
                        tint = lightBlue ,
                    )
                } ,
                trailingIcon = {
                    if (Email.isNotEmpty()) {
                        Icon(
                            imageVector = ImageVector.vectorResource(id = R.drawable.close_ic) ,
                            modifier = Modifier.clickable {
                                Email = ""
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
                        top.linkTo(email.bottom , margin = 32.dp)
                        start.linkTo(parent.start , margin = 48.dp)
                    } ,
                fontSize = 24.sp ,
                fontFamily = digital ,
                color = lightBlue
            )

            TextField(value = passwordValue ,
                onValueChange = {
                    passwordValue = it
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
                    Text(text = "password" , style = TextStyle(color = Color.Gray))
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
                        imageVector = ImageVector.vectorResource(id = password_ic) ,
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
                            contentDescription = "login" ,
                            tint = Color.Red
                        )
                    }
                })




            Button(
                onClick = { navController.navigate(Screen.HomeGraph.route) } ,
                modifier = Modifier
                    .wrapContentWidth()
                    .height(54.dp)
                    .constrainAs(loginButton) {
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        top.linkTo(password.bottom , margin = 32.dp)
                    } ,
                colors = ButtonDefaults.buttonColors(
                    containerColor = powder ,
                )
            ) {
                Text(
                    text = "log in" ,
                    fontSize = 32.sp ,
                    fontFamily = digital ,
                    color = lightBlue
                )
            }

            Text(
                text = "or no account yet ? " ,
                modifier = Modifier
                    .constrainAs(text3) {
                        top.linkTo(loginButton.bottom , margin = 32.dp)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    } ,
                fontSize = 32.sp ,
                fontFamily = digital ,
                color = lightBlue

            )

            Button(
                onClick = { navController.navigate(Screen.Signin.route) } ,
                modifier = Modifier
                    .wrapContentWidth()
                    .height(54.dp)
                    .constrainAs(singUpButton) {
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        top.linkTo(text3.bottom , margin = 32.dp)
                    } ,
                colors = ButtonDefaults.buttonColors(
                    containerColor = powder ,
                )
            ) {
                Text(
                    text = "sign in" ,
                    fontSize = 32.sp ,
                    fontFamily = digital ,
                    color = lightBlue
                )
            }
        }
    }
}

@Composable
fun EnterMessage(
    modifier: Modifier ,
    hint: String ,
    painter: Int ,
) {
    var text by remember {
        mutableStateOf("")
    }
    TextField(value = text ,
        onValueChange = {
            text = it
        } ,
        enabled = true ,
        modifier = modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .clip(RoundedCornerShape(50.dp))
            .border(
                width = 1.dp ,
                color = lightBlue ,
                shape = RoundedCornerShape(50.dp)
            ) ,
        placeholder = {
            Text(text = hint , style = TextStyle(color = Color.Gray))
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
                imageVector = ImageVector.vectorResource(painter) ,
                modifier = Modifier.clickable {
                } ,
                contentDescription = null ,
                tint = lightBlue ,
            )
        } ,
        trailingIcon = {
            if (text.isNotEmpty()) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.close_ic) ,
                    modifier = Modifier.clickable {
                        text = ""
                    } ,
                    contentDescription = "login" ,
                    tint = Color.Red
                )
            }
        })
}


@Composable
fun bio(
    modifier: Modifier
) {
    var text by remember {
        mutableStateOf("")
    }
    TextField(value = text ,
        onValueChange = {
            text = it
        } ,
        enabled = true ,
        modifier = modifier
            .wrapContentHeight()
            .heightIn(min = 100.dp)
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .clip(RoundedCornerShape(10.dp))
            .border(
                width = 1.dp ,
                color = lightBlue ,
                shape = RoundedCornerShape(15.dp)
            ) ,
        placeholder = {
            Text(text = " About " , style = TextStyle(color = Color.Gray))
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

        trailingIcon = {
            if (text.isNotEmpty()) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.close_ic) ,
                    modifier = Modifier.clickable {
                    } ,
                    contentDescription = "login" ,
                    tint = Color.Red
                )
            }

        }
    )
}
