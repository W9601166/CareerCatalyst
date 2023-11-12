package uk.ac.tees.w9601166.careercatalyst.ui.splash

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import uk.ac.tees.w9601166.careercatalyst.ui.data.database.getUserFromFireStoreDB
import uk.ac.tees.w9601166.careercatalyst.ui.data.model.AppUser
import uk.ac.tees.w9601166.careercatalyst.ui.navigation.ChatScreens
import uk.ac.tees.w9601166.careercatalyst.ui.session.SessionProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class SplashViewModel : ViewModel() {

    fun redirect(navController: NavHostController) {
        if(Firebase.auth.currentUser == null){
            navController.navigate(ChatScreens.LoginScreen.name)
            return
        }

        getUserFromFireStoreDB(
Firebase.auth.currentUser?.uid ?:""
        ){task ->
          if(!task.isSuccessful){
              navController.navigate(ChatScreens.LoginScreen.name)
          }
            val user = task.result.toObject(AppUser::class.java)
            SessionProvider.user = user
            navController.navigate(ChatScreens.HomeScreen.name)
        }
    }
}