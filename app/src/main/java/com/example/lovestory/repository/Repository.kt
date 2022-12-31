package com.example.lovestory.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.lovestory.model.LoveModel
import com.example.lovestory.model.RetrofitService
import retrofit2.Call
import retrofit2.Response


class Repository {
    fun getLiveLove(firstName:String,secondName: String):MutableLiveData<LoveModel>{

val liveData=MutableLiveData<LoveModel>()

        RetrofitService().getLoveApi().getResult(firstName,secondName).enqueue(object : retrofit2.Callback<LoveModel>{
            override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
               if (response.isSuccessful){
                   liveData.postValue(response.body())
               }
            }

            override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                Log.e("ololo", "onFailure: ${t.message}", )
            }

        })


        return liveData
    }
}