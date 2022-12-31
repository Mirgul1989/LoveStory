package com.example.lovestory.data

import android.media.Image
import java.io.Serializable

data class OnBoard(
    var image: Int?=null,
    var title: String?=null,
    var desc: String?=null
): Serializable
