package com.example.darfe.tareas.ui.main

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.darfe.tareas.R
import com.example.darfe.tareas.ui.add.AddActivity
import com.example.darfe.tareas.ui.main.adapters.TaskAdapter
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    val vm:MainViewModel by viewModel()
    val adapter:TaskAdapter = TaskAdapter()
    val categories:Array<String> by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        list.adapter = adapter
    }

    override fun onResume() {
        super.onResume()
        vm.tasks.observe(this, Observer { adapter.data = it })

        filter.setOnItemClickListener{_, _, pos,_->
            vm.filter(categories[pos])
            drawer.closeDrawers()
        }

        btnAdd.setOnClickListener { startActivity<AddActivity>() }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId){
            R.id.action_search -> toast("Buscando ...")
            R.id.action_filter -> drawer.openDrawer(filter)
        }
        return super.onOptionsItemSelected(item)
    }
}
