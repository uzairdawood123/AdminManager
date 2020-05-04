package com.example.adminmanagermvvm.feature.readEmployeeInfo.ui

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.adminmanager.Recycler.employeeListAdapter
import com.example.adminmanagermvvm.R
import com.example.adminmanagermvvm.feature.addUserInfo.model.EmployeeInfoModel
import com.example.adminmanagermvvm.feature.addUserInfo.ui.AddEmployeeInfo
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class ReadEmployeeList : AppCompatActivity() {
    private val tablename = "employee_info_mvvm"
    val ref= FirebaseDatabase.getInstance().getReference(tablename)
    lateinit var employeeList: MutableList<EmployeeInfoModel>
    lateinit var list:ListView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_read_employee_list)
        employeeList= mutableListOf()
        list= findViewById(R.id.listview)

        ref.addValueEventListener(object : ValueEventListener {

            override fun onCancelled(p0: DatabaseError) {

            }

            override fun onDataChange(p0: DataSnapshot) {

                if (p0.exists()){
                    for (postsnapshot in p0.children){
                        val employee = postsnapshot.getValue(EmployeeInfoModel::class.java)
                        if (employee != null) {
                            employeeList.add(employee)
                        }

                    }
                    val adapter=employeeListAdapter(applicationContext,R.layout.cardview,employeeList)
                    list.adapter=adapter


                }

            }


        })

    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.add, menu)
        val addnewemployee = menu!!.findItem(R.id.add)
        addnewemployee.setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener { item ->
            val i = Intent(applicationContext, AddEmployeeInfo::class.java)
            startActivity(i)
            super.onOptionsItemSelected(item)
        })
        return true
    }
}

