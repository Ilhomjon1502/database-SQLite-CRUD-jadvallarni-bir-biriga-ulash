package Adapters

import Models.Employee
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.ilhomjon.multipletablesdatabaseandroid.databinding.ItemEmployeeBinding

class EmployeeAdapter(var list: List<Employee>):BaseAdapter() {
    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(position: Int): Employee{
        return list[position]
    }

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var employeeViewHolder:EmployeeViewHolder
        if (convertView == null){
            employeeViewHolder = EmployeeViewHolder(ItemEmployeeBinding.inflate(LayoutInflater.from(parent?.context), parent, false))
        }else{
            employeeViewHolder = EmployeeViewHolder(ItemEmployeeBinding.bind(convertView))
        }

        employeeViewHolder.itemEmployeeBinding.tv.text = list[position].name

        return employeeViewHolder.itemView
    }

    inner class EmployeeViewHolder{
        val itemView:View
        var itemEmployeeBinding:ItemEmployeeBinding

        constructor(itemEmployeeBinding: ItemEmployeeBinding) {
            itemView = itemEmployeeBinding.root
            this.itemEmployeeBinding = itemEmployeeBinding
        }
    }
}