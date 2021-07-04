package com.example.entity

import androidx.room.Entity
import java.sql.Date
import java.sql.Time

@Entity(tableName = "rdv")
data class rdv(
        var qrrdv: Int,
        var iddoc: Int,
        var daterdv: String,
        var heurdrdv: String,
        var heurfrdv: String,
        var idpat:Int
)