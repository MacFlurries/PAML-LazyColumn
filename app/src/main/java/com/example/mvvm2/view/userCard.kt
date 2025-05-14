package com.example.mvvm2.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.mvvm2.R
import com.example.mvvm2.model.User

@Composable
fun userCard(user: User, index: Int, selectedIndex: Int, onClick: (Int) -> Unit) {
    val bgColor = if (index == selectedIndex)
        MaterialTheme.colorScheme.primaryContainer
    else
        MaterialTheme.colorScheme.surface

    Card(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .wrapContentHeight()
            .clickable { onClick(index) },
        shape = MaterialTheme.shapes.medium,
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)
    ) {
        Surface(color = bgColor) {
            Row(modifier = Modifier.padding(10.dp)) {
                Image(
                    painter = painterResource(R.drawable.profile_picture),
                    contentDescription = "Profile picture",
                    modifier = Modifier
                        .size(80.dp)
                        .clip(CircleShape)
                )
                Spacer(modifier = Modifier.width(16.dp))
                Column {
                    Text(text = "ID: ${user.id}", style = MaterialTheme.typography.bodyLarge)
                    Text(text = user.name, style = MaterialTheme.typography.bodyLarge)
                    Text(text = user.email, style = MaterialTheme.typography.bodyLarge)
                }
            }
        }
    }
}
