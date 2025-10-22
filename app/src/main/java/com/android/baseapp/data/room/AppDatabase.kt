package com.android.baseapp.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.android.baseapp.model.room.User

@Database(entities = [User::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}
