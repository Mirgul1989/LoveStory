package com.example.lovestory.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.lovestory.remote.LoveModel
import com.example.lovestory.repository.Repository
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoveViewModel @Inject constructor(private val repository: Repository) : ViewModel() {


    fun getLiveLoveModel(firstName: String, secondName: String): LiveData<LoveModel> {
        return repository.getLiveLove(firstName, secondName)

    }
}