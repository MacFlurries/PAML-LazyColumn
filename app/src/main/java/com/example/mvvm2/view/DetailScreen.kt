package com.example.mvvm2.view

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mvvm2.model.User
import com.example.mvvm2.viewmodel.UserViewModel

@Composable
fun DetailScreen(
    userId: Int,
    viewModel: UserViewModel
) {
    var user by remember { mutableStateOf<User?>(null) }

    LaunchedEffect(userId) {
        user = viewModel.getUserById(userId)
    }

    Column(modifier = Modifier.padding(16.dp).fillMaxSize()) {
        if (user != null) {
            Text(text = "ID: ${user!!.id}", style = MaterialTheme.typography.bodyLarge)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Nama: ${user!!.name}", style = MaterialTheme.typography.bodyLarge)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Email: ${user!!.email}", style = MaterialTheme.typography.bodyLarge)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Username: ${user!!.username}", style = MaterialTheme.typography.bodyLarge)
        } else {
            Text(text = "Loading detail user...", style = MaterialTheme.typography.bodyLarge)
        }
    }
}
