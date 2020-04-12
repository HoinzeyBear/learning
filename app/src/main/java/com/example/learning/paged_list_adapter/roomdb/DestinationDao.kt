package com.example.learning.paged_list_adapter.roomdb

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface DestinationDao {

    @Query("SELECT * FROM destinations")
    fun getAllDestinations(): LiveData<List<Destinations>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(destinations: List<Destinations>)

    @Query("SELECT * FROM destinations")
    fun getAllPagedDestinations(): DataSource.Factory<Int, Destinations>
}
