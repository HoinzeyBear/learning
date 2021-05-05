package com.example.learning.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class ViewModelWithLiveData : ViewModel() {

    private var number: MutableLiveData<String> = MutableLiveData("")

    fun getNumber(): MutableLiveData<String> {
        return number
    }

    fun generateRandomNumber() {
        Log.d(TAG, " generateRandomNumber()")
        val random = Random
        number.value = "" + random.nextInt(0, 10)
    }

    companion object {
        val TAG = "hoinzey-viewmodel"
    }
}