package com.example.newsapp.features.newsloading.data.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class News(val author: String, val title: String,
                @Expose
                @SerializedName("urlToImage")
                val urlToImage: String,
                val url: String, val source: Source)