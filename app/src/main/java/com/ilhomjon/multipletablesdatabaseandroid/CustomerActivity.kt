package com.ilhomjon.multipletablesdatabaseandroid

import DB.MyDbHelper
import Models.Customer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ilhomjon.multipletablesdatabaseandroid.databinding.ActivityCustomerBinding

class CustomerActivity : AppCompatActivity() {
    lateinit var myDbHelper: MyDbHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityCustomerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        myDbHelper = MyDbHelper(this)

        binding.btnSave.setOnClickListener {
            val name = binding.edtName.text.toString()
            val address = binding.edtAddress.text.toString()
            val postalCode = binding.edtPostalCode.text.toString()
            val country = binding.edtCountry.text.toString()

            val customer = Customer(name,address, postalCode, country)
            myDbHelper.insertCustomer(customer)
            finish()
        }
    }
}