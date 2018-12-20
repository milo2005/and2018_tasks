package com.example.darfe.tareas.data.database

import android.content.Context
import androidx.room.*
import com.example.darfe.tareas.data.database.dao.TaskDao
import com.example.darfe.tareas.data.database.model.Task
import java.util.*

object Converter{

    @TypeConverter
    fun dateToLong(date: Date):Long = date.time

    @TypeConverter
    fun longToDate(timestamp:Long):Date = Date(timestamp)

}

@TypeConverters(Converter::class)
@Database(version = 1, entities = [Task::class])
abstract class AppDatabase : RoomDatabase() {

    abstract fun taskDao(): TaskDao

    companion object {
        lateinit var db: AppDatabase
        fun init(context: Context) {
            db = Room.databaseBuilder(
                context,
                AppDatabase::class.java, "task.db"
            )
                .build()
        }
    }

}