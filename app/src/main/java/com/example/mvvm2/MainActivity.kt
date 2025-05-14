package com.example.mvvm2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavType
import androidx.navigation.compose.*
import androidx.navigation.navArgument
import com.example.mvvm2.ui.theme.Mvvm2Theme
import com.example.mvvm2.view.allUser
import com.example.mvvm2.view.UserDetailScreen

class MainActivity : ComponentActivity() {
    private val userViewModel: UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Mvvm2Theme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    val navController = rememberNavController()
                    val users by userViewModel.users.collectAsState()

                    LaunchedEffect(Unit) {
                        userViewModel.loadUsers()
                    }

                    NavHost(
                        navController = navController,
                        startDestination = "userList"
                    ) {
                        composable("userList") {
                            allUser(
                                listUser = users,
                                onUserClick = { userId ->
                                    navController.navigate("detail/$userId")
                                }
                            )
                        }

                        composable(
                            "detail/{userId}",
                            arguments = listOf(navArgument("userId") { type = NavType.IntType })
                        ) { backStackEntry ->
                            val userId = backStackEntry.arguments?.getInt("userId") ?: 0
                            UserDetailScreen(userId = userId, viewModel = userViewModel)
                        }
                    }
                }
            }
        }
    }
}
