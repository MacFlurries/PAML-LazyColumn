package com.example.mvvm2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.example.mvvm2.ui.theme.Mvvm2Theme
import com.example.mvvm2.view.allUser

class MainActivity : ComponentActivity() {
    private val userViewModel: UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Mvvm2Theme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    val userList by userViewModel.users.collectAsState()
                    allUser(userList)
                }
            }
        }
    }
}
