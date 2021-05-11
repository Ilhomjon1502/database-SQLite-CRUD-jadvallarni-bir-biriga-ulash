package DB

import Models.Customer
import Models.Employee
import Models.Order

interface DatabaseService {

    fun insertCustomer(customer: Customer)

    fun insertEmployee(employee: Employee)

    fun insertOrder(order: Order)

    fun getAllCustomer():List<Customer>

    fun getAllEmployees():List<Employee>

    fun getAllOrders():List<Order>

    fun getCustomerById(id:Int):Customer

    fun getEmployeeById(id:Int):Employee
}