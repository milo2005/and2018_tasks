package com.example.darfe.tareas.data.database

import android.content.Context
import androidx.room.*
import com.example.darfe.tareas.data.database.dao.TaskDao
import com.example.darfe.tareas.data.database.model.Task
import java.util.*

object Converter{

    @TypeConverter
    @JvmStatic
    fun dateToLong(date: Date):Long = date.time

    @TypeConverter
    @JvmStatic
    fun longToDate(timestamp:Long):Date = Date(timestamp)

}

@TypeConverters(Converter::class)
@Database(version = 1, entities = [Task::class])
abstract class AppDatabase : RoomDatabase() {

    abstract fun taskDao(): TaskDao

}