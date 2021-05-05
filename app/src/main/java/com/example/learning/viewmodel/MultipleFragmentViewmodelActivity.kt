package com.example.learning.viewmodel

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.learning.R

class MultipleFragmentViewmodelActivity : AppCompatActivity() {

    lateinit var numberGenerator: ViewModelWithLiveData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_multiple_fragment_viewmodel)

        numberGenerator = ViewModelProvider(this).get(ViewModelWithLiveData.TAG ,ViewModelWithLiveData::class.java)

        val fragmentOne = MultipleViewmodelFragOne()
        val fragmentTwo = MultipleViewmodelFragTwo()

        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()

        transaction
                .add(R.id.fragmentOne, fragmentOne, "fragmentOne")
                .add(R.id.fragmentTwo, fragmentTwo, "fragmentTwo")
                .commit()
    }
}