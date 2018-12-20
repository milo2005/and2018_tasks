package com.example.darfe.tareas.data.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
class Task(@PrimaryKey(autoGenerate = true) val id:Long? = null,
           val title:String,
           val description:String,
           val date:Date)