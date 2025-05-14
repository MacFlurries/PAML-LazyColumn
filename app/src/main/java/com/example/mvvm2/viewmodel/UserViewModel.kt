    package com.example.mvvm2.viewmodel

    import androidx.lifecycle.ViewModel
    import androidx.lifecycle.viewModelScope
    import com.example.mvvm2.Data.UserRepository
    import com.example.mvvm2.model.User
    import kotlinx.coroutines.flow.MutableStateFlow
    import kotlinx.coroutines.flow.StateFlow
    import kotlinx.coroutines.launch

    class UserViewModel : ViewModel() {
        private val _users = MutableStateFlow<List<User>>(emptyList())
        val users: StateFlow<List<User>> = _users
        val repository = UserRepository()

        fun loadUsers() {
            viewModelScope.launch {

                _users.value = repository.fetchUsers()
            }
        }

        suspend fun getUserById(id: Int): User {
            return repository.fetchUserById(id)
        }
    }
