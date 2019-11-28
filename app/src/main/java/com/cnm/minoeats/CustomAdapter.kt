package com.cnm.minoeats

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_layout.view.*

class CustomAdapter(private val itemOnClickListener: ItemOnClickListener) :
    RecyclerView.Adapter<CustomAdapter.CustomViewHolder>() {
    private val dataList = mutableListOf<FoodItem>()
    fun setList(list: List<FoodItem>) {
        dataList.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_layout, parent, false)
        return CustomViewHolder(view, itemOnClickListener)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.bind(dataList[position])
    }

    inner class CustomViewHolder(view: View, itemOnClickListener: ItemOnClickListener) :
        RecyclerView.ViewHolder(view) {
        init {
            view.setOnClickListener {
                itemOnClickListener.itemOnClick(dataList[adapterPosition])
            }
        }

        //        data를 뷰에 넣어줍니다.
        fun bind(foodItem: FoodItem) {
            itemView.iv_food.setImageResource(foodItem.foodImgResId)
            itemView.tv_name.text = foodItem.foodName
        }

    }

    interface ItemOnClickListener {
        fun itemOnClick(foodItem: FoodItem)
    }

    fun insertFirst(foodItem: FoodItem) {
        dataList.add(0, foodItem)
        notifyItemInserted(0)
    }

    fun remove(foodItem: FoodItem = dataList[0]) {
        val index = dataList.indexOf(foodItem)
        dataList.removeAt(index)
        notifyItemRemoved(index)
    }

}
