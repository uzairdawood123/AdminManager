package com.example.adminmanager.Recycler

import android.content.Context
import android.graphics.Movie
import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.adminmanagermvvm.R
import com.example.adminmanagermvvm.feature.addUserInfo.model.EmployeeInfoModel
import kotlinx.android.synthetic.main.cardview.view.*
import java.util.ArrayList

class employeeListAdapter(context: Context, val layoutid: Int, val list: List<EmployeeInfoModel>)
    : ArrayAdapter<EmployeeInfoModel>(context,layoutid,list) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflater:LayoutInflater= LayoutInflater.from(context)
        val view:View= layoutInflater.inflate(layoutid,null)
        val textviewname=view.findViewById<TextView>(R.id.name)
        val textviewphone=view.findViewById<TextView>(R.id.phone)
        val employee= list.get(position)

        textviewname.text=employee.firstname
        textviewphone.text=employee.phonenumber

        return view

    }
}

