package com.example.myapplication

data class SignInRequest(
    val type: String,
    val username: String,
    val password: String
)
