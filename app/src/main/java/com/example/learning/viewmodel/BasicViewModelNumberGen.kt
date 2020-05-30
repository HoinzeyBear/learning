package com.example.learning.viewmodel

import androidx.lifecycle.ViewModel
import kotlin.random.Random

class BasicViewModelNumberGen : ViewModel() {

    private lateinit var number: String

    fun getNumber(): String {
        if (!::number.isInitialized) {
            number = generateRandomNumber()
        }
        return number
    }

    private fun generateRandomNumber(): String {
        val random = Random
        return "" + random.nextInt(0, 10)
    }
}