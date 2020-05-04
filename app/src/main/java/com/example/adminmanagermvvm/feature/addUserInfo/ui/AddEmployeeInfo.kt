package com.example.adminmanagermvvm.feature.addUserInfo.ui

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.adminmanagermvvm.Interface.SaveListener
import com.example.adminmanagermvvm.R
import com.example.adminmanagermvvm.databinding.ActivityMainBinding
import com.example.adminmanagermvvm.feature.addUserInfo.viewmodel.SaveEmployeeInfoViewModel
import com.example.adminmanagermvvm.utils.toast
import com.google.common.io.Files
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.squareup.picasso.Picasso


class AddEmployeeInfo : AppCompatActivity(), SaveListener {
    private val tablename = "employee_info_mvvm"
    lateinit var binding: ActivityMainBinding
    val REQUESCODE = 1
    lateinit var storage: StorageReference
    var pickedImgUri: Uri? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        val viewModel = ViewModelProviders.of(this).get(SaveEmployeeInfoViewModel::class.java)

        binding.viewmodel = viewModel

        storage = FirebaseStorage.getInstance().getReference(tablename)



    }


    override fun Onsave() {
        toast("Data Saved")
    }

}
