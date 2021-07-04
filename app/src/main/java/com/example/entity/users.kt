package com.example.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "users")
data class users(
        var iduser: Int,
            var numtu:String,
            var pwd:String,
            var type:String,
            var nomu:String,
            var prenomu:String
    )