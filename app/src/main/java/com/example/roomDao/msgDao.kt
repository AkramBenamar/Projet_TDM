package com.example.roomDao

import androidx.room.*
import com.example.entity.mmg


@Dao
interface msgDao {


    @Query("select * from messages")
    fun getMessages():List<mmg>

    @Query("select * from messages  where isSynchronized=0")
    fun getMessagesToSynchronize(): mmg


    @Insert
    fun addMessage( message: mmg)

    @Update
    fun updateMessage(message: mmg)

    @Query("delete from messages")
    fun deleteAllMessages()

}