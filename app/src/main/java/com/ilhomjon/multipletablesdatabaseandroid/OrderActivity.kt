package com.ilhomjon.multipletablesdatabaseandroid

import Adapters.CustomerAdapter
import Adapters.EmployeeAdapter
import Adapters.OrderAdapter
import DB.MyDbHelper
import Models.Customer
import Models.Employee
import Models.Order
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.BaseAdapter
import com.ilhomjon.multipletablesdatabaseandroid.databinding.ActivityOrderBinding

class OrderActivity : AppCompatActivity() {
    lateinit var binding:ActivityOrderBinding
    lateinit var myDbHelper: MyDbHelper
    lateinit var customerAdapter: CustomerAdapter
    lateinit var list: List<Customer>
    lateinit var list2:List<Employee>
    lateinit var employeeAdapter: EmployeeAdapter

    lateinit var list3:ArrayList<Order>
    lateinit var orderAdapter:OrderAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOrderBinding.inflate(layoutInflater)
        setContentView(binding.root)

        myDbHelper = MyDbHelper(this)

        list = myDbHelper.getAllCustomer()
        list2 = myDbHelper.getAllEmployees()
        list3 = myDbHelper.getAllOrders()

        customerAdapter = CustomerAdapter(list)
        employeeAdapter = EmployeeAdapter(list2)
        orderAdapter = OrderAdapter(list3)

        binding.customerSpinner.adapter = customerAdapter
        binding.employeeSpinner.adapter = employeeAdapter
        binding.rv.adapter = orderAdapter

        binding.btnSave.setOnClickListener {

            val customer = list[binding.customerSpinner.selectedItemPosition]
            val employee = list2[binding.employeeSpinner.selectedItemPosition]

            val orderDate = binding.edtOrderDate.text.toString()
            val order = Order(customer, employee, orderDate)

            myDbHelper.insertOrder(order)

            list3.add(order)
            println(list3)
            orderAdapter.notifyItemInserted(list.size)
        }
    }
}