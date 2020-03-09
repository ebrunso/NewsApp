package com.example.newsapp.features.newsloading.data.service

import com.example.newsapp.features.newsloading.data.response.Response
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {
    @GET("/v2/top-headlines")
    fun getNews(@Query("country") country: String, @Query("apiKey") apiKey: String): Observable<Response>
}