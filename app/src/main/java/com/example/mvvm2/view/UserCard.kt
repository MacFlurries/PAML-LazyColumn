package com.example.mvvm2.view

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.clickable

@Composable
fun userCard(user: User, onClick: () -> Unit = {}, isDetail: Boolean = false) {
    Card(
        modifier = if (isDetail) {
            Modifier
                .fillMaxSize()
                .padding(16.dp)
        } else {
            Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(10.dp)
                .clickable { onClick() }
        },
        shape = MaterialTheme.shapes.medium,
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        )
    ) {
        Column {
            Image(
                painter = painterResource(R.drawable.profile_picture),
                contentDescription = "profile",
                modifier = if (isDetail) {
                    Modifier
                        .fillMaxWidth()
                        .height(240.dp)
                } else {
                    Modifier
                        .size(80.dp)
                        .clip(CircleShape)
                        .padding(8.dp)
                }
            )
            Column(Modifier.padding(10.dp)) {
                Text(text = "Name: ${user.name}", style = MaterialTheme.typography.headlineSmall)
                if (isDetail) {
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(text = "ID: ${user.id}", style = MaterialTheme.typography.bodyMedium)
                    Text(text = "Username: ${user.username}", style = MaterialTheme.typography.bodyMedium)
                    Text(text = "Phone: ${user.phone}", style = MaterialTheme.typography.bodyMedium)
                    Text(text = "Website: ${user.website}", style = MaterialTheme.typography.bodyMedium)
                    Text(
                        text = "Address: ${user.address.street}, ${user.address.suite}, ${user.address.city}, ${user.address.zipcode}",
                        style = MaterialTheme.typography.bodySmall
                    )
                    Text(
                        text = "Geo: (${user.address.geo.lat}, ${user.address.geo.lng})",
                        style = MaterialTheme.typography.bodySmall
                    )
                    Text(text = "Company: ${user.company.name}", style = MaterialTheme.typography.bodySmall)
                    Text(text = "CatchPhrase: ${user.company.catchPhrase}", style = MaterialTheme.typography.bodySmall)
                    Text(text = "Business: ${user.company.bs}", style = MaterialTheme.typography.bodySmall)
                } else {
                    Text(text = "Email: ${user.email}", style = MaterialTheme.typography.bodyLarge)
                }
            }
        }
    }
}

