package com.example.crud.localdatasource.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.crud.localdatasource.entitys.UserEntity

@Dao
interface UserItemDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(userItem: UserEntity): Long

    @Update
    suspend fun update(userItem: UserEntity)

    @Delete
    suspend fun delete(userItem: UserEntity)

    @Query("SELECT * FROM UserEntity WHERE uid = :id")
    suspend fun getById(id: Int): UserEntity?

    @Query("SELECT * FROM UserEntity")
    suspend fun getAll(): List<UserEntity>
}