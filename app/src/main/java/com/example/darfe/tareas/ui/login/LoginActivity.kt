package com.example.darfe.tareas.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import com.example.darfe.tareas.R
import com.example.darfe.tareas.ui.main.MainActivity
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class LoginActivity : AppCompatActivity() {

    val vm:LoginViewModel by lazy { ViewModelProviders.of(this)
        .get(LoginViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if(vm.isLogged()){
            // val intent = Intent(this, MainActivity::class.java)
            // startActivity(intent)
            startActivity<MainActivity>()
            finish()
            return
        }

        setContentView(R.layout.activity_login)
    }

    override fun onResume() {
        super.onResume()
        btnLogin.setOnClickListener {
            val emailText = email.editText!!.text.toString()
            val passText = password.editText!!.text.toString()

            if(vm.login(emailText, passText)){
                startActivity<MainActivity>()
                finish()
            }else{
                // Toast.makeText(this, "menaje", Toast.LENGTH_SHORT).show()
                toast("Email o contraseña erroneo")
            }
        }
    }
}
