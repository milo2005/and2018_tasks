package com.example.darfe.tareas.ui.main

import androidx.lifecycle.*
import com.example.darfe.tareas.data.database.AppDatabase
import com.example.darfe.tareas.data.database.dao.TaskDao
import com.example.darfe.tareas.data.database.model.Task

class MainViewModel:ViewModel(){

    private val dao: TaskDao = AppDatabase.db.taskDao()
    private val filterLD: MutableLiveData<String> = MutableLiveData()
    private val searchLD: MutableLiveData<String> = MutableLiveData()

    private val filterDao:LiveData<List<Task>> = Transformations
        .switchMap(filterLD){ dao.findByCategory(it)}

    private val searchDao:LiveData<List<Task>> = Transformations
        .switchMap(searchLD){ dao.findByTitle(it)}

    val tasks:LiveData<List<Task>> = MediatorLiveData<List<Task>>().apply {
        addSource(filterDao){ value = it }
        addSource(searchDao){ value = it }
        addSource(dao.all()){ value = it }
    }



    fun filter(category:String){
        filterLD.value = category
    }

    fun search(title:String){
        searchLD.value = "%$title%"
    }


}