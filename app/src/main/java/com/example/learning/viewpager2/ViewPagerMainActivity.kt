package com.example.learning.viewpager2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.viewpager2.widget.ViewPager2
import com.example.learning.R
import kotlinx.android.synthetic.main.activity_view_pager_main.*
import com.example.learning.viewpager2.fragmentpager.FooItems
import com.example.learning.viewpager2.fragmentpager.MyFragmentStateAdapter

class ViewPagerMainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pager_main)

        setupViewPager()
        setupViewPagerWithFragments()
    }

    fun setupViewPagerWithFragments() {
        val adapter = MyFragmentStateAdapter(this, FooItems.list!!)

        viewPagerWithFragment.adapter = adapter
        viewPagerWithFragment.orientation = ViewPager2.ORIENTATION_HORIZONTAL
    }

    fun setupViewPager() {
        val adapter = ViewPageAdapter(this, Items.list!!)

        viewPager2.adapter = adapter;
        viewPager2.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        viewPager2.registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                Toast.makeText(this@ViewPagerMainActivity, "$position selected", Toast.LENGTH_SHORT)
                        .show()
            }
        })
    }
}
