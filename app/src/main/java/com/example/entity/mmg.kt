package com.example.entity
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "messages")
data class mmg (
    var iduser:Int,
    var message:String,
    var idrec:Int,
    var isSynchronized:Int =0
)
{
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "idmsg")
    var idmsg:Int?=null
}