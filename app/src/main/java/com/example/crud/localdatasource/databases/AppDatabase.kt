package com.example.crud.localdatasource.databases

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.crud.localdatasource.daos.UserItemDao
import com.example.crud.localdatasource.entitys.UserEntity


@Database(
    version = 1,
    exportSchema = true,
    entities = [
        UserEntity::class
    ]
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userItemDao(): UserItemDao
}