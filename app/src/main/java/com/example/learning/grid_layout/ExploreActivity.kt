package com.example.learning.grid_layout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.learning.R
import com.example.learning.grid_layout.model.Task
import kotlinx.android.synthetic.main.activity_explore.*
import kotlinx.android.synthetic.main.activity_main.*

class ExploreActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_explore)

        setupRecyclerView()
    }

    private fun setupRecyclerView() {

        val adapter = ExploreAdapter(this, Task.list!!)
        recyclerView.adapter = adapter

//        val layoutManager = GridLayoutManager(this, 2)
        val layoutManager = StaggeredGridLayoutManager(2, RecyclerView.VERTICAL)
//        layoutManager.orientation = RecyclerView.VERTICAL
        recyclerView.layoutManager = layoutManager
    }
}
