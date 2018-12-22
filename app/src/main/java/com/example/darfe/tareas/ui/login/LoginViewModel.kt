package com.example.darfe.tareas.ui.login

import androidx.lifecycle.ViewModel
import com.example.darfe.tareas.data.preference.UserSession

class LoginViewModel(private val session:UserSession):ViewModel(){

    fun login(email:String, password:String):Boolean =
        if(email == "admin@email.com" && password == "1234"){
            session.email = email
            session.logged = true
            true
        }else false

    fun isLogged():Boolean = session.logged

}