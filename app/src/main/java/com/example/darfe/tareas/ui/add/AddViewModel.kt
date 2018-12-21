package com.example.darfe.tareas.ui.add

import androidx.lifecycle.ViewModel
import com.example.darfe.tareas.data.database.AppDatabase
import com.example.darfe.tareas.data.database.dao.TaskDao
import com.example.darfe.tareas.data.database.model.Task
import kotlin.concurrent.thread

class AddViewModel:ViewModel(){

    private val dao:TaskDao = AppDatabase.db.taskDao()

    fun add(task: Task){
        thread(true) { dao.insert(task) }
    }

    fun update(task:Task){
        thread (true){ dao.update(task) }
    }

}