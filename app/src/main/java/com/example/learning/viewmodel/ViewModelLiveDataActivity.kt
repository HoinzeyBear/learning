package com.example.learning.viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.learning.R
import kotlinx.android.synthetic.main.activity_basic_view_model.*
import kotlinx.android.synthetic.main.activity_view_model_live_data.*

class ViewModelLiveDataActivity : AppCompatActivity() {

    lateinit var numberGenerator: ViewModelWithLiveData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_model_live_data)
        supportActionBar?.hide()

        numberGenerator = ViewModelProvider(this).get(ViewModelWithLiveData::class.java)

        numberGenerator.getNumber().observe(this, Observer<String> { number ->
            livedatatv.text = number
        })

        livedatabtn.setOnClickListener {
            numberGenerator.generateRandomNumber()
        }
    }
}