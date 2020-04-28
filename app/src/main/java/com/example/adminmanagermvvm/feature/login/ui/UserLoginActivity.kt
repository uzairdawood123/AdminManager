package com.example.adminmanagermvvm.feature.login.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.adminmanagermvvm.R
import com.example.adminmanagermvvm.databinding.ActivityMainBinding
import com.example.adminmanagermvvm.feature.addUserInfo.ui.AddEmployeeInfo

class UserLoginActivity : AppCompatActivity() {
    lateinit var bindings: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindings = DataBindingUtil.setContentView(this,R.layout.activity_user_login)



        val intent = Intent(applicationContext, AddEmployeeInfo::class.java)
        startActivity(intent)
    }
}
