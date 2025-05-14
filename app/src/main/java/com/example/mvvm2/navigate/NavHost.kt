package com.example.mvvm2.navigate


import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.mvvm2.view.DetailScreen
import com.example.mvvm2.view.allUser
import com.example.mvvm2.viewmodel.UserViewModel

@Composable
fun AppNavHost(
    navController: NavHostController,
    userViewModel: UserViewModel,
    startDestination: String = NavItem.List.route
) {
    val users by userViewModel.users.collectAsState()

    NavHost(navController = navController, startDestination = startDestination) {
        composable(NavItem.List.route) {
            allUser(
                listUser = users,
                onUserClick = { userId ->
                    navController.navigate("${NavItem.Detail.route}/$userId")
                }
            )
        }

        composable(
            "${NavItem.Detail.route}/{userId}",
            arguments = listOf(navArgument("userId") { type = NavType.IntType })
        ) { backStackEntry ->
            val userId = backStackEntry.arguments?.getInt("userId") ?: 0
            DetailScreen(userId = userId, viewModel = userViewModel)
        }
    }
}
