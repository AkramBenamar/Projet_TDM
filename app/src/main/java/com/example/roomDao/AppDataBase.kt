package com.example.roomDao
import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.entity.mmg
import com.example.roomDao.msgDao


@Database(entities = arrayOf(mmg::class),version = 1)
abstract class AppDataBase:RoomDatabase() {

    abstract fun getMsgDao(): msgDao

}