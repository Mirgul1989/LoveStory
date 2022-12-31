package com.example.lovestory.data

import android.content.Context
import android.content.Context.MODE_PRIVATE

class Pref(context: Context) {
    private val pref = context.getSharedPreferences("pref_name", MODE_PRIVATE)


    fun isOnBoardingShow(): Boolean {
        return pref.getBoolean(BOARDING_SHOW, false)
    }

    fun saveShowOnBoarding(isShow: Boolean) {
        pref.edit().putBoolean(BOARDING_SHOW, isShow).apply()
    }


    companion object {
        private const val BOARDING_SHOW = "on_boarding_show"
    }


}