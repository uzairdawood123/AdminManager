package com.example.adminmanagermvvm

import SAMPLE
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.example.adminmanagermvvm.EmployeeInfoModel


class MainActivity : AppCompatActivity() {
    lateinit var edit: EditText
    lateinit var button: Button
    private val tablename = "user_info"
    var firebaseDatabase: FirebaseDatabase? = null
    var databaseReference: DatabaseReference?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        edit=findViewById(R.id.edt1)
        button=findViewById(R.id.btn)
        button.setOnClickListener{
            savedata()
        }

//        firebaseDatabase = FirebaseDatabase.getInstance()
//        databaseReference = firebaseDatabase!!.getReference(tablename)
    }
    private fun savedata(){
        val name= edit.text.toString()
        val hero=EmployeeInfoModel(name)

        val ref= FirebaseDatabase.getInstance().getReference(tablename)
        val ids= ref.push().key
        if (ids != null) {
            ref.child(ids).setValue(hero)
            Toast.makeText(applicationContext,"saved",Toast.LENGTH_SHORT).show()

        }

    }
}
