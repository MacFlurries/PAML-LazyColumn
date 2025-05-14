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
import androidx.navigation.compose.rememberNavController
import com.example.mvvm2.navigate.AppNavHost
import com.example.mvvm2.ui.theme.Mvvm2Theme
import com.example.mvvm2.viewmodel.UserViewModel

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

                    AppNavHost(
                        navController = navController,
                        userViewModel = userViewModel
                    )
                }
            }
        }
    }
}
