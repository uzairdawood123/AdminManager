package com.example.adminmanagermvvm.feature.login.viewmodel

import android.content.Context
import android.content.Intent
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.example.adminmanagermvvm.Interface.SaveListener

class LoginViewModel: ViewModel() {

    var save: SaveListener?=null

    fun loginbuttonclick(view: View){
        save?.Onsave()
    }
}