package com.example.lovestory.di

import android.content.Context
import com.example.lovestory.App
import com.example.lovestory.data.Pref
import com.example.lovestory.remote.LoveApi
import com.example.lovestory.room.AppDataBase
import com.example.lovestory.room.LoveDao
import dagger.Module
import dagger.Provides
import dagger.hilt.DefineComponent
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    fun provideApp():LoveApi {
        return Retrofit.Builder().baseUrl("https://love-calculator.p.rapidapi.com/")
            .addConverterFactory(GsonConverterFactory.create()).build().create(LoveApi::class.java)
    }

    @Provides
    fun providePref (@ApplicationContext context: Context ):Pref{
        return Pref(context)
    }
    @Provides
    fun provideRoom(@ApplicationContext context: Context) : AppDataBase{
        return App.appDataBase
    }
    @Provides
    fun getDao(appDatabase: AppDataBase): LoveDao {
        return appDatabase.getDao()

    }
}