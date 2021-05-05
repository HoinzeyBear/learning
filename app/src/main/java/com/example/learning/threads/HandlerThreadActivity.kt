package com.example.learning.threads

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.HandlerThread
import android.os.Message
import android.view.View
import com.example.learning.R
import kotlinx.android.synthetic.main.activity_handler_thread.*
import kotlinx.android.synthetic.main.activity_thread_looper_handler.*
import java.lang.ref.WeakReference

class HandlerThreadActivity : AppCompatActivity(), Handler.Callback {

    var firstNumber: Int = 0
    var secondNumber: Int = 0

    var handlerThread: HandlerThread? = null
    var mainThreadHandler: Handler? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_handler_thread)
        mainThreadHandler = Handler(this)
    }

    override fun onStart() {
        super.onStart()
        this.handlerThread = HandlerThread("Handler Thread")
        this.handlerThread?.start()
    }

    override fun onStop() {
        super.onStop()
        this.handlerThread?.quit()
    }

    private fun updateViews(data: Bundle?) {
        val result = data?.getInt("result")
        ht_result.text = result.toString()
    }

    fun onClickAdd(view: View) {
        firstNumber = ht_first_number.text.toString().toInt()
        secondNumber = ht_second_number.text.toString().toInt()

        val backgroundHandler = Handler(handlerThread?.looper)
        backgroundHandler.post(AddNumbers(firstNumber, secondNumber, mainThreadHandler))
    }

    override fun handleMessage(msg: Message): Boolean {
        when (msg.what) {
            HT_ADDITION_SUCCESS -> updateViews(msg.data)
        }
        return true
    }

    private inner class AddNumbers(val firstNumber: Int = -1,
                                   val secondNumber: Int = -1,
                                   val mainThreadHandler: Handler?,
                                   var mainThreadHandlerWeakRef: WeakReference<Handler>? = null) : Runnable {


        init {
            this.mainThreadHandlerWeakRef = WeakReference<Handler>(mainThreadHandler)
        }

        override fun run() {
            val result = firstNumber + secondNumber
            val message: Message = Message.obtain(null, HT_ADDITION_SUCCESS)
            val bundle = Bundle()
            bundle.putInt("result", result)
            message.data = bundle

            mainThreadHandlerWeakRef?.get()?.sendMessage(message)
        }
    }
}
