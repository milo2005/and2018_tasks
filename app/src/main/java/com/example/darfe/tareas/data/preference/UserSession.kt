package com.example.darfe.tareas.data.preference

import android.content.SharedPreferences

class UserSession(private val preferences: SharedPreferences){

    var logged:Boolean
        get() = preferences.getBoolean("logged", false)
        set(value) = preferences.edit().putBoolean("logged", value).apply()

    var email:String?
        get() = preferences.getString("email", null)
        set(value) = preferences.edit().putString("email", value).apply()

}