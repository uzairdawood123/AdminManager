package com.example.adminmanagermvvm.feature.addNewUser.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.adminmanagermvvm.R
import com.example.adminmanagermvvm.databinding.ActivityAddNewUserBinding
import com.example.adminmanagermvvm.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class AddNewUserActivity : AppCompatActivity() {
    lateinit var binding: ActivityAddNewUserBinding
    private var mDatabaseReference: DatabaseReference? = null
    private var mDatabase: FirebaseDatabase? = null
    private var mAuth: FirebaseAuth? = null
    private var firstName: String? = null
    var lastname: String? = null
    val tablename = "user_MvvM"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_new_user)
        mDatabase = FirebaseDatabase.getInstance()

        mDatabaseReference = mDatabase!!.reference!!.child(tablename)
        mAuth = FirebaseAuth.getInstance()
        binding.btnAddNewuser.setOnClickListener {
            createaccount()
        }
    }


    fun createaccount() {
        firstName = binding.firstNameValue?.text.toString()
        lastname = binding.lastNameValue?.text.toString()

        mAuth!!
            .createUserWithEmailAndPassword(firstName!!, lastname!!)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val userId = mAuth!!.currentUser!!.uid
                    val currentUserDb = mDatabaseReference!!.child(userId)
                    currentUserDb.child("firstName").setValue(firstName)
                    currentUserDb.child("lastName").setValue(lastname)
                    Toast.makeText(
                        applicationContext, "User Added.",
                        Toast.LENGTH_SHORT
                    ).show()

                } else {
                    Toast.makeText(
                        applicationContext, "Authentication failed." + task.exception,
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
    }
//    private fun updateUserInfoAndUI() {
//        //start next activity
//        val intent = Intent(applicationContext, MainActivity::class.java)
//        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
//        startActivity(intent)
//    }
}
