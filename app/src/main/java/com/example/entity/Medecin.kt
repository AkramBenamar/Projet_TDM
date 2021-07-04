package com.example.entity

import java.io.Serializable

data class Medecin(
val iddoc:Int,
    val nom:String, val prenom:String, val num_tel:String,
    val specialite:String, var photo:String, var longitude: Double, var latitude: Double,
    var annee: Int,
    var fb:String
):Serializable