package com.example.learning.recyclerview_2

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.learning.R
import com.example.learning.grid_layout.ExploreActivity
import com.sriyank.vacationspots.Destination
import kotlinx.android.synthetic.main.recycler_view_2_list_item.view.*

class MainViewAdapter(val context: Context, var destinationList: ArrayList<Destination>) : RecyclerView.Adapter<MainViewAdapter.MainViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val itemView: View = LayoutInflater.from(context).inflate(R.layout.recycler_view_2_list_item, parent, false)
        return MainViewHolder(itemView)
    }

    override fun getItemCount(): Int = destinationList.size

    override fun onBindViewHolder(mainViewHolder: MainViewHolder, position: Int) {
        val destination = destinationList[position]
        mainViewHolder.populate(destination, position)
        mainViewHolder.setListeners()
    }

    inner class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        var currentPosition: Int = -1
        var destination: Destination? = null

        fun populate(destination: Destination, position: Int) {
            itemView.apply {
                //This is an interesting method
                txvPlaceName.text = destination.placeName
                imvPlace.setImageResource(destination.imageId)
            }
            this.currentPosition = position
            this.destination = destination
        }

        fun setListeners() {
            itemView.apply {
                imvDelete.setOnClickListener(this@MainViewHolder)
                imvMakeCopy.setOnClickListener(this@MainViewHolder)
                rootCardView.setOnClickListener(this@MainViewHolder)
            }
        }

        override fun onClick(v: View?) {
            when (v!!.id) {
                R.id.imvDelete -> deleteItem()
                R.id.imvMakeCopy -> duplicateItem()
                R.id.rootCardView -> openExploreActivity()
            }
        }

        fun deleteItem() {
            destinationList.removeAt(currentPosition)
            notifyItemRemoved(currentPosition)
            notifyItemRangeChanged(currentPosition, destinationList.size)
        }

        fun duplicateItem() {
            destinationList.add(currentPosition, destination!!)
            notifyItemInserted(currentPosition)
            notifyItemRangeChanged(currentPosition, destinationList.size)
        }

        fun openExploreActivity() {
            val intent = Intent(context, ExploreActivity::class.java)
            context.startActivity(intent)
        }
    }

}