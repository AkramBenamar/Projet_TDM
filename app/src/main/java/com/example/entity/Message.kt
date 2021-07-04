package com.example.entity

import java.io.Serializable

data class Message(
        val idmsg:Int,
        val iduser:Int,

        val message:String,
        val idrec:Int
):Serializable