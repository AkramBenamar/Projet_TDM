package com.example

import android.app.Application
import com.example.roomDao.RoomService


class App:Application(){
    override fun onCreate() {
        super.onCreate()
        RoomService.context = applicationContext
    }
}