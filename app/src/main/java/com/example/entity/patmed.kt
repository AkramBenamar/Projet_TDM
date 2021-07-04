package com.example.entity

import androidx.room.Entity
import java.sql.Time

@Entity(tableName = "agenda")
data class patmed(
        var iddoc: Int,

        var idpat: Int,
        var daterdv:String
)