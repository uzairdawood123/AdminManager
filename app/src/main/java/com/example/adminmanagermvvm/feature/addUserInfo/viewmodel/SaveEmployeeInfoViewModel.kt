package com.example.adminmanagermvvm.feature.addUserInfo.viewmodel

import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.example.adminmanagermvvm.Interface.SaveListener
import com.example.adminmanagermvvm.feature.addUserInfo.model.EmployeeInfoModel
import com.google.firebase.database.FirebaseDatabase

class SaveEmployeeInfoViewModel: ViewModel() {
    private val tablename = "user_info"
    var savelistner: SaveListener?=null
    var firstname: String? = null
    var lastname: String? = null
    var phonenumber: String? = null
    var email: String? = null
    var address: String? = null
    var joinigsalary: String? = null
    var accounnumber: String? = null

    fun onbutton(view: View){
        val firs_tname= firstname
        val last_name = lastname
        val phone_number= phonenumber
        val email = email
        val address= address
        val joining_salary = joinigsalary
        val account_number= accounnumber

        val employeeinfo= EmployeeInfoModel(firs_tname,last_name,phone_number,email,address,joining_salary,account_number)



        val ref= FirebaseDatabase.getInstance().getReference(tablename)
        val ids= ref.push().key
        if (ids != null) {
            ref.child(ids).setValue(employeeinfo)
            savelistner?.Onsave()
        }


    }


}