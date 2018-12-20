package com.example.darfe.tareas

import android.app.Application
import com.example.darfe.tareas.data.database.AppDatabase
import com.example.darfe.tareas.data.preference.UserSession

class App:Application(){

    override fun onCreate() {
        super.onCreate()
        AppDatabase.init(this)
        UserSession.init(this)
    }

}