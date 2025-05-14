package com.example.mvvm2.Data


import com.example.mvvm2.service.RetrofitInstance
import com.example.mvvm2.service.UserService

class UserRepository {
    private val api: UserService = RetrofitInstance.userService

    suspend fun fetchUsers() = api.getUsers()
    suspend fun fetchUserById(id: Int) = api.getUser(id)
}