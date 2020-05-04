package com.example.adminmanagermvvm.feature.login.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.adminmanagermvvm.Interface.SaveListener
import com.example.adminmanagermvvm.R
import com.example.adminmanagermvvm.databinding.ActivityMainBinding
import com.example.adminmanagermvvm.databinding.ActivityUserLoginBinding
import com.example.adminmanagermvvm.feature.addNewUser.ui.AddNewUserActivity
import com.example.adminmanagermvvm.feature.addUserInfo.ui.AddEmployeeInfo
import com.example.adminmanagermvvm.feature.addUserInfo.viewmodel.SaveEmployeeInfoViewModel
import com.example.adminmanagermvvm.feature.dashboard.ui.DashboardScreenActivity
import com.example.adminmanagermvvm.feature.login.viewmodel.LoginViewModel
import com.example.adminmanagermvvm.feature.readEmployeeInfo.ui.ReadEmployeeList
import com.example.adminmanagermvvm.utils.toast
import com.google.firebase.auth.FirebaseAuth

class UserLoginActivity : AppCompatActivity(),SaveListener{
    lateinit var bindings: ActivityUserLoginBinding
    private var mAuth: FirebaseAuth? = null
    private var email: String? = null
    private var password: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindings = DataBindingUtil.setContentView(this,R.layout.activity_user_login)
        mAuth = FirebaseAuth.getInstance()

        val viewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)

        bindings.viewmodel = viewModel
        bindings.btnLogin.setOnClickListener {
//            onclick()
            loginUser()
        }





    }

    fun onclick(){
        val intent = Intent(applicationContext, AddNewUserActivity::class.java)
        startActivity(intent)

    }

    override fun Onsave() {
        toast("click")
    }
    private fun loginUser() {
        email = bindings.userNameValue?.text.toString()
        password = bindings.userPasswordValue?.text.toString()
            mAuth!!.signInWithEmailAndPassword(email!!, password!!)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {

                        updateUserInfoAndUI()
                    } else {
                        Toast.makeText(applicationContext, "Authentication failed."+task.exception.toString(),
                            Toast.LENGTH_SHORT).show()
                    }
                }
    }
    private fun updateUserInfoAndUI() {
        val intent = Intent(applicationContext, DashboardScreenActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }
}
