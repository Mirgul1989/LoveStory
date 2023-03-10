package com.example.lovestory.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.lovestory.remote.LoveApi
import com.example.lovestory.remote.LoveModel
import com.example.lovestory.room.LoveDao
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject


class Repository @Inject constructor(private val api: LoveApi) {

    fun getLiveLove(firstName: String, secondName: String): MutableLiveData<LoveModel> {
        val liveData = MutableLiveData<LoveModel>()

        api.getResult(firstName, secondName)
            .enqueue(object : retrofit2.Callback<LoveModel> {
                override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                    if (response.isSuccessful) {
                        liveData.postValue(response.body())
                    }
                }

                override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                    Log.e("ololo", "onFailure: ${t.message}")
                }

            })


        return liveData
    }



}