package Models

class Order {
    var id:Int? = null

    //agregation - clas ichida class kelishi
    var customer:Customer? = null
    var employee:Employee? = null
    var orderDate:String? = null

    constructor(customer: Customer?, employee: Employee?, orderDate: String?) {
        this.customer = customer
        this.employee = employee
        this.orderDate = orderDate
    }

    constructor()

}