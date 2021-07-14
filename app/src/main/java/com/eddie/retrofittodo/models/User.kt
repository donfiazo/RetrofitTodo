package com.eddie.retrofittodo.models

data class User(
    val address: Address,
    val email: String,
    val id: Int,
    val name: String,
    val username: String
)