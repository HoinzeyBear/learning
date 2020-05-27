package com.example.learning.threads

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message


class TLHThread(private var mainThreadCallback: Handler?) : Thread() {

    private var myHandler: MyHandler? = null
    private var isRunning = false

    init {
        this.isRunning = true
    }

    override fun run() {
        if (isRunning) {
            Looper.prepare()
            myHandler = MyHandler(Looper.myLooper())
            Looper.loop()
        }
    }

    fun killThread() {
        this.isRunning = false
        mainThreadCallback = null
    }

    private fun add(data: Bundle?) {
        if (data != null) {
            val firstNumber = data.getInt("first")
            val secondNumber = data.getInt("second")

            val result = firstNumber + secondNumber

            val message: Message = Message.obtain(null, TLH_ADDITION_SUCCESS)
            val bundle = Bundle()
            bundle.putInt("result", result)
            message.data = bundle

            mainThreadCallback?.sendMessage(message)
        } else {
            val message: Message = Message.obtain(null, TLH_ADDITION_FAIL)
            mainThreadCallback?.sendMessage(message)
        }
    }

    private fun subtract(data: Bundle?) {
        if (data != null) {
            val firstNumber = data.getInt("first")
            val secondNumber = data.getInt("second")

            val result = firstNumber - secondNumber

            val message: Message = Message.obtain(null, TLH_SUBTRACTION_SUCCESS)
            val bundle = Bundle()
            bundle.putInt("result", result)
            message.data = bundle

            mainThreadCallback?.sendMessage(message)
        } else {
            val message: Message = Message.obtain(null, TLH_SUBTRACTION_FAIL)
            mainThreadCallback?.sendMessage(message)
        }
    }

    fun sendMessageToBackgroundThread(data: Message) {
        while (true) {
            try {
                myHandler!!.handleMessage(data)
                break
            } catch (exception: NullPointerException) {
                try {
                    Thread.sleep(100)
                } catch (exception: InterruptedException) {
                    exception.printStackTrace()
                }
            }
        }
    }

    inner class MyHandler(looper: Looper?) : Handler(looper) {

        override fun handleMessage(msg: Message?) {
            when (msg?.what) {
                TLH_ADD -> add(msg.data)
                TLH_SUBTRACT -> subtract(msg.data)
            }
        }
    }
}