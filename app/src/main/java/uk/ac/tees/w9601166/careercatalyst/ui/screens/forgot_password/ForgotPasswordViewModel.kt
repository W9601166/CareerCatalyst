package uk.ac.tees.w9601166.careercatalyst.ui.screens.forgot_password

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class ForgotPasswordViewModel : ViewModel() {
    val emailState = mutableStateOf("")
    val emailError = mutableStateOf("")
    val showLoading = mutableStateOf(false)
    val message = mutableStateOf("")
    val showDialog =  mutableStateOf(false)
     private val auth = Firebase.auth

    private fun validateFields(): Boolean {

        if (emailState.value.isEmpty() || emailState.value.isBlank()) {
            emailError.value = "Email Required"
            return false
        } else
            emailError.value = ""
        return true
    }

    @SuppressLint("SuspiciousIndentation")
    fun resetPasswordWithEmail() {
        if (!validateFields()) return
            showLoading.value = true
            resetPassword()
    }

    private fun resetPassword() {
        auth.sendPasswordResetEmail(emailState.value)
            .addOnCompleteListener(){
                showLoading.value = false
                Log.d("TAG", it.isSuccessful.toString())
                if (it.isSuccessful) {
                    showDialog.value = true
                    Log.e("TAG", "If email exists, Reset email will be sent, check your email")
                    message.value = "Email Sent"

                } else {
                    //show Error Dialog
                    message.value = it.exception?.localizedMessage ?: ""
                    showDialog.value = true
                    Log.e("TAG", "resetPasswordEmail: ${it.exception?.localizedMessage}")
                }
            }

    }

}