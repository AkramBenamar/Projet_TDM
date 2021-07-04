package com.example.entity

import androidx.room.Entity

@Entity(tableName = "infordv")
data class infordv(
        var qrrdv:Int,
        var iddoc:Int,
        var daterdv:String,
        var heurdrdv:String,
        var heurfrdv:String,
        var idpat:Int,
        var nom:String,
        var prenom:String,
        var specialite:String,
        var nomp:String,
        var prenomp:String

)