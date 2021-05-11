package com.ilhomjon.multipletablesdatabaseandroid

import DB.MyDbHelper
import Models.Employee
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ilhomjon.multipletablesdatabaseandroid.databinding.ActivityCustomerBinding
import com.ilhomjon.multipletablesdatabaseandroid.databinding.ActivityEmployeeBinding

class EmployeeActivity : AppCompatActivity() {
    lateinit var binding: ActivityEmployeeBinding
    lateinit var myDbHelper: MyDbHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEmployeeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        myDbHelper = MyDbHelper(this)
        binding.btnSaveEmployee.setOnClickListener {
            val name = binding.edtNameEmployee.text.toString()
            val employee = Employee(name)

            myDbHelper.insertEmployee(employee)
            finish()
        }
    }
}