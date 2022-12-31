package com.example.lovestory.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.lovestory.model.LoveModel
import com.example.lovestory.repository.Repository

class LoveViewModel:ViewModel() {

   private val repository = Repository()

    fun getLiveLoveModel(firstName: String, secondName: String):LiveData<LoveModel>{

        return repository.getLiveLove(firstName,secondName)

    }
}