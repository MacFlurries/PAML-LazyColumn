package com.example.mvvm2.model

import com.google.gson.annotations.SerializedName

// Define data model for Address
data class Address(
    val street: String,
    val suite: String,
    val city: String,
    val zipcode: String,
    val geo: Geo
)

// Define data model for Geo (Coordinates)
data class Geo(
    val lat: String,
    val lng: String
)

// Define data model for Company
data class Company(
    val name: String,
    @SerializedName("catchPhrase") val catchPhrase: String,
    val bs: String
)

// Define data model for User
data class User(
    val id: Int,
    val name: String,
    val username: String,
    val email: String,
    val address: Address,
    val phone: String,
    val website: String,
    val company: Company
)