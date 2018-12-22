package com.example.darfe.tareas.ui.add

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.lifecycle.ViewModelProviders
import com.example.darfe.tareas.R
import com.example.darfe.tareas.data.database.model.Task
import com.example.darfe.tareas.util.text
import kotlinx.android.synthetic.main.activity_add.*
import org.jetbrains.anko.toast
import java.util.*

class AddActivity : AppCompatActivity() {

    val vm: AddViewModel by lazy {
        ViewModelProviders.of(this)
            .get(AddViewModel::class.java)
    }

    val categoryNames:Array<String>
            by lazy{ resources.getStringArray(R.array.categories)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        title = getString(R.string.add_task)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }

    override fun onResume() {
        super.onResume()

        btnCancel.setOnClickListener { finish() }
        btnOk.setOnClickListener {
            val name = inputTitle.text()
            val des = inDescription.text()
            if (name == "" || des == "") {
                toast("Titulo y descripción obligatorios")
                return@setOnClickListener
            }

            val cat = categoryNames[categories.selectedItemPosition]
            val task = Task(null, name, des, cat, Date())
            vm.add(task)
            finish()
        }

    }
}
