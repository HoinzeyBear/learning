package com.example.learning.viewpager2.fragmentpager

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter


class MyFragmentStateAdapter(context: Context, val itemList: List<Foo>) : FragmentStateAdapter(context as FragmentActivity) {
    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun createFragment(position: Int): Fragment {
        val foo = itemList[position]

        return SlideFragment(foo)
    }


}