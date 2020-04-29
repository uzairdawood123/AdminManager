package com.example.adminmanagermvvm.feature.addUserInfo.ui

import android.os.Bundle
import android.view.Menu
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.adminmanagermvvm.Interface.SaveListener
import com.example.adminmanagermvvm.feature.addUserInfo.model.EmployeeInfoModel
import com.example.adminmanagermvvm.R
import com.example.adminmanagermvvm.databinding.ActivityMainBinding
import com.example.adminmanagermvvm.feature.addUserInfo.viewmodel.SaveEmployeeInfoViewModel
import com.example.adminmanagermvvm.utils.toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase


class AddEmployeeInfo : AppCompatActivity(), SaveListener {
    lateinit var binding: ActivityMainBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        val viewModel = ViewModelProviders.of(this).get(SaveEmployeeInfoViewModel::class.java)

        binding.viewmodel = viewModel


    }


    override fun Onsave() {
        toast("Data Saved")
    }
}
