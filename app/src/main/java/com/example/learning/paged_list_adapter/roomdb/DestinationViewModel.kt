package com.example.learning.paged_list_adapter.roomdb

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import androidx.paging.toLiveData


class DestinationViewModel(application: Application): AndroidViewModel(application) {

    val destinationsLiveData: LiveData<PagedList<Destinations>>

    init {
        val appDatabase = AppDatabase.getDatabase(application)
        val destinationDao = appDatabase!!.destinationDao()

        val dataSourceFactory = destinationDao.getAllPagedDestinations()

        destinationsLiveData = dataSourceFactory.toLiveData(pageSize = 10)
    }
}