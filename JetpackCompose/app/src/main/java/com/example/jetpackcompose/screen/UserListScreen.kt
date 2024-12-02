package com.example.jetpackcompose.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.jetpackcompose.model.UserListViewModel


@Composable
fun UserListScreen(
    navController: NavController,

) {
    val viewModel: UserListViewModel = viewModel()
    val users = viewModel.userList
    Column(modifier = Modifier.padding(16.dp)) {
        users.forEach { user ->
            Text(
                text = user.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .clickable {
                        navController.navigate("user_details/${user.id}")
                    }
            )
        }
    }
}
