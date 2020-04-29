package com.example.adminmanagermvvm.feature.dashboard.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import com.example.adminmanagermvvm.R
import com.example.adminmanagermvvm.databinding.ActivityDashboardScreenBinding
import com.example.adminmanagermvvm.databinding.ActivityUserLoginBinding
import com.example.adminmanagermvvm.feature.readEmployeeInfo.ui.ReadEmployeeList

class DashboardScreenActivity : AppCompatActivity() {
    lateinit var bindings: ActivityDashboardScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindings = DataBindingUtil.setContentView(this,R.layout.activity_dashboard_screen)
        bindings.addemployee.setOnClickListener {
            onclick()
        }

    }
    fun onclick(){
        val intent = Intent(applicationContext, ReadEmployeeList::class.java)
        startActivity(intent)

    }
}
