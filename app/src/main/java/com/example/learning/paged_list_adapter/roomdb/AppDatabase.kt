package com.example.learning.paged_list_adapter.roomdb

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Destinations::class], version = 1)
abstract class AppDatabase: RoomDatabase() {

    abstract fun destinationDao(): DestinationDao

    companion object {

        private var appDatabase: AppDatabase? = null

        fun initDatabase(context: Context): AppDatabase? {

            if (appDatabase == null) {
                synchronized(AppDatabase::class.java) {
                    if (appDatabase == null) {
                        appDatabase = Room.databaseBuilder(
                            context.applicationContext,
                            AppDatabase::class.java,
                            "app_database").build()
                    }
                }
            }
            return appDatabase
        }

        fun getDatabase(context: Context): AppDatabase? = appDatabase
            ?: initDatabase(context)
    }
}
