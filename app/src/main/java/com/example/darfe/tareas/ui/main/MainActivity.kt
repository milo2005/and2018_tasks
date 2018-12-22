package com.example.darfe.tareas.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.darfe.tareas.R
import com.example.darfe.tareas.ui.add.AddActivity
import com.example.darfe.tareas.ui.main.adapters.TaskAdapter
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {

    val vm:MainViewModel by lazy{ ViewModelProviders.of(this)
        .get(MainViewModel::class.java)}

    val adapter:TaskAdapter = TaskAdapter()

    val categories:Array<String>
            by lazy { resources.getStringArray(R.array.categories) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        list.adapter = adapter
    }

    override fun onResume() {
        super.onResume()
        vm.tasks.observe(this, Observer { adapter.data = it })

        filter.setOnItemClickListener{_, _, pos,_-> vm.filter(categories[pos])  }

        btnAdd.setOnClickListener { startActivity<AddActivity>() }
    }
}
