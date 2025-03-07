package com.example.crud.remotedatasource.request

data class UserResponse (
    val id: String,
    val name: String,
    val lastName: String,
    val active: Boolean
)