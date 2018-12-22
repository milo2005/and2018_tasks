package com.example.darfe.tareas

import android.app.Application
import com.example.darfe.tareas.di.appModule
import org.koin.android.ext.android.startKoin

class App:Application(){

    override fun onCreate() {
        super.onCreate()
        startKoin(this, listOf(appModule))
    }

}