package com.example.learning.paged_list_adapter.roomdb

import android.app.Application
import android.os.AsyncTask

class MyApplication: Application() {

    private var destinationDao: DestinationDao? = null

    override fun onCreate() {
        super.onCreate()

        val appDatabase = AppDatabase.initDatabase(this)
        destinationDao = appDatabase!!.destinationDao()
        insertAll(VacationSpots.list!!) // Populate database when app starts
    }

    private fun insertAll(destinations: List<Destinations>) {
        InsertAsyncTask(destinationDao!!).execute(destinations)
    }

    companion object {
        private class InsertAsyncTask(private val destinationDao: DestinationDao) : AsyncTask<List<Destinations>, Void, Void>() {

            override fun doInBackground(vararg params: List<Destinations>): Void? {

                destinationDao.insertAll(params[0])
                return null
            }
        }
    }
}
