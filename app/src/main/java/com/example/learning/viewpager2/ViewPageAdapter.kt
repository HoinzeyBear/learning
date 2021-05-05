package com.example.learning.viewpager2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.learning.R
import kotlinx.android.synthetic.main.item_page.view.*

class ViewPageAdapter(val context: Context, val itemList: List<Item>) : RecyclerView.Adapter<ViewPageAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val itemView = LayoutInflater.from(context).inflate(R.layout.item_page, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int = itemList.size

    override fun onBindViewHolder(myViewHolder: MyViewHolder, position: Int) {

        myViewHolder.setData(itemList[position])
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun setData(item: Item) {

            itemView.txvItemNumber.text = item.itemNumber

            val color = ContextCompat.getColor(context, item.colorId)
            itemView.rootCardView.setCardBackgroundColor(color)
        }
    }
}