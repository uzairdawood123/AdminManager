package com.example.adminmanagermvvm

data class EmployeeInfoModel (
    val useremail: String){

    companion object {
    @JvmStatic fun callStatic() {}
    fun callNonStatic() {}
}
}
