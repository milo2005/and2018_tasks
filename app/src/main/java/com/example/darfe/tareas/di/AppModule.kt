package com.example.darfe.tareas.di

import android.content.Context
import androidx.room.Room
import com.example.darfe.tareas.data.database.AppDatabase
import com.example.darfe.tareas.data.database.model.Task
import com.example.darfe.tareas.data.preference.UserSession
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module.Module
import org.koin.dsl.module.module
import org.koin.experimental.builder.scope
import org.koin.experimental.builder.single
import java.util.*

val appModule: Module = module {

    // App Database
    single {
        Room.databaseBuilder(
            androidContext(), AppDatabase::class.java, "task.db"
        ).build()
    }

    single { get<AppDatabase>().taskDao() }

    // Session

    single {
        androidContext().getSharedPreferences(
            "preferencias",
            Context.MODE_PRIVATE
        )
    }

    // single{ UserSession(get()) }
    single<UserSession>()


    /*single { Task(null, "", "", "", Date()) }
    scope("account") {
        // depdencia 1
    }
    scope("account") {
        // depdencia 2
    }
    factory {  }

    single("obj1"){Task(null, "", "", "", Date())}*/

}