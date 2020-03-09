package com.example.newsapp.features.newsloading.data

import com.example.newsapp.features.newsloading.data.response.News
import com.example.newsapp.features.newsloading.data.service.NewsService
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
open class DataManager @Inject
constructor(private val newsAPIService: NewsService) {

    fun getNewsList(country: String, apiKey: String): Observable<MutableList<News>> {
        return newsAPIService.getNews(country, apiKey).map{
            it.articles
        }
    }

}