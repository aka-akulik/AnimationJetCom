package com.example.jetpackcompose.screen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.scaleIn
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil3.compose.AsyncImage
import com.example.jetpackcompose.RetrofitService.RetrofitInstance
import kotlinx.coroutines.runBlocking

@Composable

fun UserDetailsScreen(navController: NavController, userId: Int) {
    val user = remember { runBlocking { RetrofitInstance.api.getUsers().find { it.id == userId } } }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        user?.let {
            AnimatedVisibility(
                visible = true,
                enter = fadeIn() + scaleIn()
            ) {
                AsyncImage(
                    modifier = Modifier.size(150.dp),
                    model = "https://via.placeholder.com/150",
                    contentDescription = null
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text("Name: ${user.name}")
            Text("Username: ${user.username}")
            Text("Email: ${user.email}")
            Text("Website: ${user.website}")
        }
    }
}