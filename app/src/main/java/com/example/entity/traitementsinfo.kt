package com.example.entity

import androidx.room.Entity

@Entity(tableName = "traitementsinfo")
data class traitementsinfo(
        var iddoc:Int,
        var idtraitement:Int,
        var maladie:String,
        var desctraitement:String,
        var datedtraitement:String,
        var dateftraitement:String,
        var nom:String,
        var prenom:String,
        var specialite:String

)