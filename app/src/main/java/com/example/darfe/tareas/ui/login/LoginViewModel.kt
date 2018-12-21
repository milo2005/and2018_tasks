package com.example.darfe.tareas.ui.login

import androidx.lifecycle.ViewModel
import com.example.darfe.tareas.data.preference.UserSession

class LoginViewModel:ViewModel(){

    fun login(email:String, password:String):Boolean =
        if(email == "admin@email.com" && password == "1234"){
            UserSession.email = email
            UserSession.logged = true
            true
        }else false

    fun isLogged():Boolean = UserSession.logged

}