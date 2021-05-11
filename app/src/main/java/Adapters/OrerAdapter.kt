package Adapters

import Models.Order
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ilhomjon.multipletablesdatabaseandroid.databinding.ItemOrderBinding

class OrderAdapter(val list: List<Order>)
    : RecyclerView.Adapter<OrderAdapter.Vh>(){

    inner class Vh(var itemOrderBinding: ItemOrderBinding):RecyclerView.ViewHolder(itemOrderBinding.root){

        fun onBind(order: Order){
            itemOrderBinding.tvCustomer.text = order.customer?.name
            itemOrderBinding.tvEmployee.text = order.employee?.name
            itemOrderBinding.tvDate.text = order.orderDate
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemOrderBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}