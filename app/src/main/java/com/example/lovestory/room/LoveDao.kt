package com.example.lovestory.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.lovestory.remote.LoveModel

@Dao
interface LoveDao {


    @Query("SELECT*FROM lovemodel ORDER BY firstName,secondName ASC")
    fun getAll(): LiveData<List<LoveModel>>

    @Insert
    fun insert(model: LoveModel)

    @Update
    fun update(loveModel: LoveModel)
}