package com.example.lovestory.remote

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable
@Entity
data class LoveModel(
    @SerializedName("fname")
var firstName:String? = null,

    @SerializedName("sname")
var secondName:String?= null,
var percentage:String? = null,
var result:String? = null,
@PrimaryKey(autoGenerate = true)
val id:Int


): Serializable
