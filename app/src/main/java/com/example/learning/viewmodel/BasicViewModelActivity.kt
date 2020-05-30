package com.example.learning.viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.learning.R
import kotlinx.android.synthetic.main.activity_basic_view_model.*

class BasicViewModelActivity : AppCompatActivity() {

    lateinit var numberGenerator: BasicViewModelNumberGen

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basic_view_model)

        numberGenerator = ViewModelProvider(this).get(BasicViewModelNumberGen::class.java)
        val myNumber = numberGenerator.getNumber()
        randomnum.text = myNumber
    }
}
