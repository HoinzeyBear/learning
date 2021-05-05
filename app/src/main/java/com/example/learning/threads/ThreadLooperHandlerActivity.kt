package com.example.learning.threads

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.view.View
import com.example.learning.R
import kotlinx.android.synthetic.main.activity_bound_service.view.*
import kotlinx.android.synthetic.main.activity_thread_looper_handler.*

class ThreadLooperHandlerActivity : AppCompatActivity(), Handler.Callback {

    var firstNumber: Int = 0
    var secondNumber: Int = 0

    var backgroundThread: TLHThread? = null
    var handler: Handler? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thread_looper_handler)
        handler = Handler(this)
    }

    override fun onStart() {
        super.onStart()
        this.backgroundThread = TLHThread(handler)
        this.backgroundThread?.start()
    }

    override fun onStop() {
        super.onStop()
        backgroundThread?.killThread()
    }

    private fun updateViews(data: Bundle?) {
        val result = data?.getInt("result")
        tlh_result.text = result.toString()
    }

    fun onClickAdd(view: View) {
        firstNumber = first_number.text.toString().toInt()
        secondNumber = second_number.text.toString().toInt()

        val data: Message = Message.obtain(null, TLH_ADD)
        val bundle = Bundle()
        bundle.putInt("first", firstNumber)
        bundle.putInt("second", secondNumber)
        data.data = bundle

        backgroundThread?.sendMessageToBackgroundThread(data)
    }

    fun onClickSubtract(view: View) {

    }

    override fun handleMessage(msg: Message): Boolean {
        when (msg.what) {
            TLH_ADDITION_SUCCESS, TLH_SUBTRACTION_SUCCESS -> updateViews(msg.data)
        }
        return true
    }
}
