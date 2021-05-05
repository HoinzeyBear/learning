package com.example.learning.recyclerview_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.learning.R
import com.sriyank.vacationspots.VacationSpots
import kotlinx.android.synthetic.main.activity_recycler2_main.*

class Recycler2MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler2_main)
        setupRecyclerView()
    }

    fun setupRecyclerView() {
        val adapter = MainViewAdapter(this, VacationSpots.list!!)
        recyclerView2.adapter = adapter

        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = RecyclerView.VERTICAL

        recyclerView2.layoutManager = layoutManager
    }
}
