package com.example.darfe.tareas.data.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.darfe.tareas.data.database.model.Task

@Dao
interface TaskDao {

    @Insert
    fun insert(task: Task)

    @Update
    fun update(task: Task)

    @Delete
    fun remove(task:Task)

    @Query("SELECT * FROM task WHERE id = :id")
    fun taskById(id:Long):Task

    @Query("SELECT * FROM task ORDER BY date DESC")
    fun all(): LiveData<List<Task>>

    @Query("SELECT * FROM task WHERE title LIKE :title")
    fun findByTitle(title:String):LiveData<List<Task>>

    @Query("SELECT * FROM task WHERE category = :category")
    fun findByCategory(category:String):LiveData<List<Task>>


}