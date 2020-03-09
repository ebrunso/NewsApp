package com.example.newsapp.features.newsloading.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.newsapp.features.newsloading.data.response.News

class ArticleViewModel : ViewModel() {
    val author = MutableLiveData<String>()
    val title = MutableLiveData<String>()
    val source = MutableLiveData<String>()
    val articleImage = MutableLiveData<String>()
    val articleLink = MutableLiveData<String>()

    fun bind(article: News) {
        author.value = article.author
        title.value = article.title
        source.value = article.source.name
        articleImage.value = article.urlToImage
        articleLink.value = article.url
    }
}