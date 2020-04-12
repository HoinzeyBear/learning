package com.example.learning.paged_list_adapter.roomdb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.learning.R
import kotlinx.android.synthetic.main.activity_paged_list.*

class PagedListActivity : AppCompatActivity() {

        private lateinit var destinationViewModel: DestinationViewModel

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_paged_list)

            destinationViewModel = ViewModelProviders.of(this).get(DestinationViewModel::class.java)

            btnLoadData.setOnClickListener {
                btnLoadData.visibility = View.GONE
                setupRecyclerView()
            }
        }

        private fun setupRecyclerView() {

            val adapter = PagedListAdapter(this)
            recyclerView_paged_list.adapter = adapter

            val layoutManager = LinearLayoutManager(this)
            layoutManager.orientation = RecyclerView.VERTICAL
            recyclerView_paged_list.layoutManager = layoutManager

            destinationViewModel.destinationsLiveData.observe(this,
                    Observer { destinations ->
                        adapter.submitList(destinations)
                    })
        }
    }
