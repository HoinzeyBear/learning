package com.example.learning.threads

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.learning.R
import kotlinx.android.synthetic.main.activity_async_task.*

class AsyncTaskActivity : AppCompatActivity() {

    var firstNumber: Int = 0
    var secondNumber: Int = 0

    private var myAsyncTask: MyAsyncTask? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_async_task)
    }

    fun onClickAdd(view: View) {
        firstNumber = async_first_number.text.toString().toInt()
        secondNumber = async_second_number.text.toString().toInt()

        if (myAsyncTask != null) {
            myAsyncTask?.cancel(true)
        }
        myAsyncTask = MyAsyncTask()
        myAsyncTask?.execute(firstNumber, secondNumber)
    }

    override fun onStop() {
        super.onStop()
        if (myAsyncTask != null) {
            myAsyncTask?.cancel(true)
        }
    }

    private inner class MyAsyncTask : AsyncTask<Int,                  //Param passed to doInBackground()
            Unit,                     //Param passed to onProgressUpdate()
            Int>() {   //Param returned from doInBackground() and passed to onPostExecute()

        var result: Int = -1

        //Executes on Main Thread
        override fun onPreExecute() {
            super.onPreExecute()
        }

        override fun onProgressUpdate(vararg values: Unit?) {
            super.onProgressUpdate(*values)
        }

        //        Executes on Background Thread
        override fun doInBackground(vararg params: Int?): Int? {
            val first = params[0]
            val second = params[1]
            return first?.plus(second!!)
        }

        //Executes on Main Thread
        override fun onPostExecute(result: Int?) {
            super.onPostExecute(result)
            async_result.text = result.toString()//is this a memory issue ?
        }
    }

}
