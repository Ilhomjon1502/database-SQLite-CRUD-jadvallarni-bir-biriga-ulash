package Adapters

import Models.Customer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.ilhomjon.multipletablesdatabaseandroid.databinding.ItemCustomerBinding

class CustomerAdapter(var list:List<Customer>) : BaseAdapter(){

    override fun getCount(): Int = list.size

    override fun getItem(position: Int): Customer {
        return list[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var customerViewHolder:CustomerViewHolder
        if (convertView == null){
            val binding = ItemCustomerBinding.inflate(LayoutInflater.from(parent?.context))
            customerViewHolder = CustomerViewHolder(binding)
        }else{
            customerViewHolder = CustomerViewHolder(ItemCustomerBinding.bind(convertView))
        }
        customerViewHolder.itemCustomerBinding.tvCustomer.text = list[position].name

        return customerViewHolder.itemView
    }

    inner class CustomerViewHolder{
        val itemView:View
        var itemCustomerBinding:ItemCustomerBinding

        constructor(itemCustomerBinding: ItemCustomerBinding) {
            itemView = itemCustomerBinding.root
            this.itemCustomerBinding = itemCustomerBinding
        }
    }
}