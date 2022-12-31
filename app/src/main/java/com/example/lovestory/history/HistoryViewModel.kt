package com.example.lovestory.history

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.lovestory.remote.LoveModel

import com.example.lovestory.repository.RoomRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HistoryViewModel @Inject constructor(private val repository: RoomRepository) : ViewModel() {
    fun getLiveLoveHistory(): LiveData<List<LoveModel>> {
        return repository.getAll()
    }

    fun getInsert(loveModel: LoveModel) {
        return repository.insert(loveModel)

    }
}