package com.example.darfe.tareas.ui.main.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.darfe.tareas.R
import com.example.darfe.tareas.data.database.model.Task
import com.example.darfe.tareas.databinding.TemplateTaskBinding
import java.text.SimpleDateFormat
import java.util.*

class TaskAdapter: RecyclerView.Adapter<TaskViewHolder>(){

    var data:List<Task> = emptyList()
        set(value){
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val view:View = LayoutInflater.from(parent.context)
            .inflate(R.layout.template_task, parent, false)

        return TaskViewHolder(view)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.bind(data[position])
    }

}


class TaskViewHolder(view:View): RecyclerView.ViewHolder(view){

    private val binding:TemplateTaskBinding = TemplateTaskBinding.bind(view)
    private val dateFormat = SimpleDateFormat("yyyy/MM/dd", Locale.getDefault())

    fun bind(task: Task){
        binding.dateText = dateFormat.format(task.date)
        binding.task = task

    }

}