package com.example.entity

import androidx.room.Entity
import java.sql.Time

@Entity(tableName = "agenda")
data class agenda(
        var ida: Int,
        var iddoc: Int,
        var jour:String,
        var heurd:String,
        var heurf: String
)