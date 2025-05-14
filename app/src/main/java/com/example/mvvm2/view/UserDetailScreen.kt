package com.example.mvvm2.view

import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mvvm2.UserViewModel

@Composable
fun UserDetailScreen(userId: Int, viewModel: UserViewModel = viewModel()) {
    val user by viewModel.selectedUser.collectAsState()

    LaunchedEffect(userId) {
        viewModel.fetchUserDetail(userId)
    }

    if (user != null) {
        userCard(user = user!!, isDetail = true)
    } else {
        Text("Loading detail...")
    }
}