package com.example.mvvm2.view


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mvvm2.model.User

@Composable
fun allUser(
    listUser: List<User>,
    onUserClick: (Int) -> Unit
) {
    var selectedIndex by remember { mutableStateOf(-1) }

    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(10.dp)
    ) {
        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(vertical = 20.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Daftar Pengguna", style = MaterialTheme.typography.headlineMedium)
            }
        }
        itemsIndexed(listUser) { index, user ->
            userCard(user, index, selectedIndex) {
                onUserClick(user.id)
            }

            if (index != listUser.size - 1) {
                Divider(modifier = Modifier.padding(vertical = 8.dp))
            }
        }
    }
}