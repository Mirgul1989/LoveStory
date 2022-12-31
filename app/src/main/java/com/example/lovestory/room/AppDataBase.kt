package com.example.lovestory.room

import androidx.room.Database
import androidx.room.Entity
import androidx.room.RoomDatabase
import com.example.lovestory.remote.LoveModel

@Database(entities = [LoveModel::class], version = 1)
abstract class AppDataBase : RoomDatabase() {
    abstract fun getDao(): LoveDao
}