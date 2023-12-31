package uk.ac.tees.w9601166.careercatalyst.ui.screens.forgot_password

import ChatAlertDialog
import ChatButton
import LoadingDialog
import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import uk.ac.tees.w9601166.careercatalyst.R
import uk.ac.tees.w9601166.careercatalyst.ui.components.ChatAppBar
import uk.ac.tees.w9601166.careercatalyst.ui.components.ChatAuthTextField
import uk.ac.tees.w9601166.careercatalyst.ui.navigation.ChatScreens


@Composable
fun ForgotPasswordScreen(navController: NavHostController, viewModel: ForgotPasswordViewModel) {
    ForgotPasswordContent(viewModel = viewModel, navController = navController)
}


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ForgotPasswordContent(viewModel: ForgotPasswordViewModel, navController: NavHostController) {

    Scaffold(modifier = Modifier.fillMaxSize(), topBar = {
       ChatAppBar(topAppTitle = "Forgot Password?")
    }) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .paint(
                    painter = painterResource(id = R.drawable.background_pattern),
                    contentScale = ContentScale.FillBounds // scaleType = fitXY
                )
        ) {
            Spacer(modifier = Modifier.fillMaxHeight(0.4F))
            ChatAuthTextField(
                state = viewModel.emailState,
                label = "Email",
                errorState = viewModel.emailError
            )

            Spacer(modifier = Modifier.padding(vertical = 8.dp))
            TextButton(onClick = {
                navController.navigate(ChatScreens.LoginScreen.name)
            }) {
                Text(
                    modifier = Modifier.padding(start = 8.dp),
                    text = "Already have an Account?", style = TextStyle(
                        fontSize = 16.sp, color = colorResource(
                            id = R.color.black
                        )
                    )
                )
            }
            Spacer(modifier = Modifier.padding(vertical = 16.dp))

            ChatButton(buttonText = "Reset Password") {
                viewModel.resetPasswordWithEmail()
            }

            if (viewModel.showLoading.value) LoadingDialog()

            if (viewModel.message.value.isNotEmpty() && viewModel.showDialog.value) ChatAlertDialog(
                alertMessage = {
                    Text(text = viewModel.message.value, textAlign = TextAlign.Center, style = TextStyle(
                        fontSize = 18.sp,
                       color = Color.DarkGray,
                    )
                    )
                },
                onDismissRequest = {
                    viewModel.showDialog.value = false
                },
                dismissButton = {
                    TextButton(onClick = {
                        viewModel.showDialog.value = false
                    }) { Text(text = "Cancel") }
                }
            ) {
                TextButton(onClick = {
                    if(viewModel.message.value == "Email Sent")
                        navController.navigate(ChatScreens.LoginScreen.name)
                    viewModel.showDialog.value = false
                }) { Text(text = "OK") }
            }
        }
    }
}


