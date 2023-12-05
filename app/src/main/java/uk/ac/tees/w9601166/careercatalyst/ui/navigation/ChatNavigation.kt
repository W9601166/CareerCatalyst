package uk.ac.tees.w9601166.careercatalyst.ui.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import uk.ac.tees.w9601166.careercatalyst.ui.screens.add_room.AddRoomScreen
import uk.ac.tees.w9601166.careercatalyst.ui.screens.add_room.AddRoomViewModel
import uk.ac.tees.w9601166.careercatalyst.ui.screens.chat_room.ChatRoomScreen
import uk.ac.tees.w9601166.careercatalyst.ui.screens.chat_room.ChatRoomViewModel
import uk.ac.tees.w9601166.careercatalyst.ui.screens.home.HomeScreen
import uk.ac.tees.w9601166.careercatalyst.ui.screens.home.HomeViewModel
import uk.ac.tees.w9601166.careercatalyst.ui.screens.jobs.JobsScreen
import uk.ac.tees.w9601166.careercatalyst.ui.screens.jobs.JobsViewModel
import uk.ac.tees.w9601166.careercatalyst.ui.screens.forgot_password.ForgotPasswordScreen
import uk.ac.tees.w9601166.careercatalyst.ui.screens.forgot_password.ForgotPasswordViewModel
import uk.ac.tees.w9601166.careercatalyst.ui.screens.login.LoginScreen
import uk.ac.tees.w9601166.careercatalyst.ui.screens.login.LoginViewModel
import uk.ac.tees.w9601166.careercatalyst.ui.screens.register.RegisterScreen
import uk.ac.tees.w9601166.careercatalyst.ui.screens.register.RegisterViewModel
import uk.ac.tees.w9601166.careercatalyst.ui.splash.SplashScreen
import uk.ac.tees.w9601166.careercatalyst.ui.splash.SplashViewModel

@Composable
fun ChatNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = ChatScreens.SplashScreen.name) {

        composable(route = ChatScreens.SplashScreen.name) {
            val viewModel: SplashViewModel = viewModel()
            SplashScreen(viewModel = viewModel, navController = navController)
        }

        composable(route = ChatScreens.RegisterScreen.name) {
            val viewModel: RegisterViewModel = viewModel()
            RegisterScreen(viewModel = viewModel, navController = navController)
        }

        composable(route = ChatScreens.ForgotPasswordScreen.name) {
            val viewModel: ForgotPasswordViewModel = viewModel()
            ForgotPasswordScreen(viewModel = viewModel, navController = navController)
        }

        composable(route = ChatScreens.LoginScreen.name) {
            val viewModel: LoginViewModel = viewModel()
            LoginScreen(viewModel = viewModel, navController = navController)
        }

        composable(route = ChatScreens.HomeScreen.name) {
            val viewModel: HomeViewModel = viewModel()
            HomeScreen(viewModel = viewModel, navController = navController)
        }

        composable(route = ChatScreens.AddRoomScreen.name){
            val viewModel : AddRoomViewModel = viewModel()
            AddRoomScreen(viewModel = viewModel, navController = navController)
        }

        composable(route = ChatScreens.ChatRoomScreen.name){
            val viewModel : ChatRoomViewModel = viewModel()
            ChatRoomScreen(viewModel,navController)
        }

        composable(route = ChatScreens.ReedsJobs.name){
            val viewModel : JobsViewModel = viewModel()
            JobsScreen(navController, viewModel)
        }

    }

}