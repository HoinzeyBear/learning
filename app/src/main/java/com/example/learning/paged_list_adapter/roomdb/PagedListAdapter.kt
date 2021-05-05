package com.example.learning.paged_list_adapter.roomdb

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.learning.R
import kotlinx.android.synthetic.main.recycler_view_2_list_item.view.*

class PagedListAdapter(val context: Context): androidx.paging.PagedListAdapter<Destinations,PagedListAdapter.MyViewHolder>(DestinationDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val itemView = LayoutInflater.from(context).inflate(R.layout.recycler_view_2_list_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(itemViewHolder: MyViewHolder, position: Int) {

        val destination = getItem(position)
        itemViewHolder.setData(destination!!, position)
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var currentPosition: Int        = -1
        var destination: Destinations?   = null

        fun setData(destination: Destinations, position: Int) {
            itemView.apply {
                txvPlaceName.text = destination.placeName
                imvPlace.setImageResource(destination.imageId)
            }

            this.currentPosition = position
            this.destination = destination
        }
    }

    class DestinationDiffCallback: DiffUtil.ItemCallback<Destinations>() {
        override fun areItemsTheSame(oldItem: Destinations, newItem: Destinations): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Destinations, newItem: Destinations): Boolean {
            return oldItem == newItem
        }

    }
}