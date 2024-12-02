package com.example.jetpackcompose.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpackcompose.RetrofitService.RetrofitInstance
import kotlinx.coroutines.launch

class UserListViewModel : ViewModel() {
    var userList: List<User> = emptyList()
        private set

    init {
        viewModelScope.launch {
            try {
                userList = RetrofitInstance.api.getUsers()
            } catch (_: Exception) {
            }
        }
    }
}
