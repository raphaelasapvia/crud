package com.example.crud.localdatasource.entitys

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserEntity(
    @PrimaryKey(autoGenerate = false) val uid: Int = 1,
    @ColumnInfo("name") val name: String = "",
    @ColumnInfo("last_name") val lastName: Boolean = false,
    @ColumnInfo("active") val active: Boolean = true
)