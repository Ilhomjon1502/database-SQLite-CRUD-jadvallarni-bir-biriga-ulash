package com.ilhomjon.multipletablesdatabaseandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ilhomjon.multipletablesdatabaseandroid.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCustomer.setOnClickListener {
            startActivity(Intent(this, CustomerActivity::class.java))
        }
        binding.btnEmploye.setOnClickListener {
            startActivity(Intent(this, EmployeeActivity::class.java))
        }
        binding.btnOrder.setOnClickListener {
            startActivity(Intent(this, OrderActivity::class.java))
        }
    }
}