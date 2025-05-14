package com.example.mvvm2

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvm2.model.User
import com.example.mvvm2.model.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class UserViewModel : ViewModel() {
    private val repository = UserRepository()

    private val _users = MutableStateFlow<List<User>>(emptyList())
    val users: StateFlow<List<User>> = _users

    private val _selectedUser = MutableStateFlow<User?>(null)
    val selectedUser: StateFlow<User?> = _selectedUser

    fun loadUsers() {
        viewModelScope.launch {
            _users.value = repository.fetchUsers()
        }
    }

    fun fetchUserDetail(id: Int) {
        viewModelScope.launch {
            _selectedUser.value = repository.fetchUserById(id)
        }
    }
}
