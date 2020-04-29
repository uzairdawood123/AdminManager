package com.example.adminmanagermvvm.feature.login.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.adminmanagermvvm.Interface.SaveListener
import com.example.adminmanagermvvm.R
import com.example.adminmanagermvvm.databinding.ActivityMainBinding
import com.example.adminmanagermvvm.databinding.ActivityUserLoginBinding
import com.example.adminmanagermvvm.feature.addUserInfo.ui.AddEmployeeInfo
import com.example.adminmanagermvvm.feature.addUserInfo.viewmodel.SaveEmployeeInfoViewModel
import com.example.adminmanagermvvm.feature.dashboard.ui.DashboardScreenActivity
import com.example.adminmanagermvvm.feature.login.viewmodel.LoginViewModel
import com.example.adminmanagermvvm.feature.readEmployeeInfo.ui.ReadEmployeeList
import com.example.adminmanagermvvm.utils.toast

class UserLoginActivity : AppCompatActivity(),SaveListener{
    lateinit var bindings: ActivityUserLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindings = DataBindingUtil.setContentView(this,R.layout.activity_user_login)

        val viewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)

        bindings.viewmodel = viewModel
        bindings.btnLogin.setOnClickListener {
            onclick()
        }





    }

    fun onclick(){
        val intent = Intent(applicationContext, DashboardScreenActivity::class.java)
        startActivity(intent)

    }

    override fun Onsave() {
        toast("click")
    }
}
