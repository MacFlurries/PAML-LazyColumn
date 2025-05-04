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

@Composable
fun userCard(user: User) {
    Card(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .wrapContentHeight(),
        shape = MaterialTheme.shapes.medium,
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        )
    ) {
        Row {
            Image(
                painter = painterResource(R.drawable.profile_picture),
                contentDescription = "profile",
                modifier = Modifier
                    .size(80.dp)
                    .clip(CircleShape)
            )
            Column(Modifier.padding(10.dp)) {
                Text(text = "ID: ${user.id}", style = MaterialTheme.typography.bodyLarge)
                Text(text = "Name: ${user.name}", style = MaterialTheme.typography.bodyLarge)
                Text(text = "Username: ${user.username}", style = MaterialTheme.typography.bodyLarge)
                Text(text = "Email: ${user.email}", style = MaterialTheme.typography.bodyLarge)
                Text(text = "Phone: ${user.phone}", style = MaterialTheme.typography.bodyLarge)
                Text(text = "Website: ${user.website}", style = MaterialTheme.typography.bodyLarge)
                Text(text = "Address: ${user.address.street}, ${user.address.suite}, ${user.address.city}, ${user.address.zipcode}", style = MaterialTheme.typography.bodyMedium)
                Text(text = "Geo: (${user.address.geo.lat}, ${user.address.geo.lng})", style = MaterialTheme.typography.bodySmall)
                Text(text = "Company: ${user.company.name}", style = MaterialTheme.typography.bodyMedium)
                Text(text = "CatchPhrase: ${user.company.catchPhrase}", style = MaterialTheme.typography.bodySmall)
                Text(text = "Business: ${user.company.bs}", style = MaterialTheme.typography.bodySmall)
            }
        }
    }
}
