package com.example.adminmanagermvvm.feature.addUserInfo.model

data class EmployeeInfoModel (
    val firstname: String?,
    val lastname: String? ,
    val phonenumber: String? ,
    val email: String? ,
    val address: String? ,
    val joinigsalary: String? ,
    val accounnumber: String? ){
    constructor(): this("","","","","",""," "){

    }


//    companion object : MutableList<EmployeeInfoModel> {
//    @JvmStatic fun callStatic() {}
//    fun callNonStatic() {}
//}
}
