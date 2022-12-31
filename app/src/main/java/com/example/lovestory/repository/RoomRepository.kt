package com.example.lovestory.repository

import androidx.lifecycle.LiveData
import com.example.lovestory.remote.LoveModel
import com.example.lovestory.room.LoveDao
import javax.inject.Inject

class RoomRepository @Inject constructor(private val appDao: LoveDao) {
    fun getAll(): LiveData<List<LoveModel>> {
        return appDao.getAll()

    }
    fun insert(loveModel: LoveModel) {
        appDao.insert(loveModel)
    }

}