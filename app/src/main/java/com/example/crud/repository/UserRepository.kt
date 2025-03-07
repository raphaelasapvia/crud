package com.example.crud.repository

import com.example.crud.localdatasource.entitys.UserEntity

interface UserRepository {
    suspend fun createUser(userItem: UserEntity): Result<UserEntity>
    suspend fun getUserById(id: Int): Result<UserEntity>
    suspend fun getAllUsers(): Result<List<UserEntity>>
    suspend fun updateUser(id: Int, userItem: UserEntity): Result<UserEntity>
    suspend fun deleteUser(id: Int): Result<Unit>
}