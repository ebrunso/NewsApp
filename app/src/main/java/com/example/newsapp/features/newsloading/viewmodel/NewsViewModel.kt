package com.example.newsapp.features.newsloading.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.newsapp.features.newsloading.data.DataManager
import com.example.newsapp.features.newsloading.data.response.News
import com.example.newsapp.features.newsloading.view.NewsAdapter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class NewsViewModel(private val dataManager: DataManager) : ViewModel() {
    private val disposables: CompositeDisposable = CompositeDisposable()
    private lateinit var country: String
    val newsListAdapter = NewsAdapter(this)

    private val urlMutableLiveData = MutableLiveData<String>()
    val urlLiveData: LiveData<String>
        get() = urlMutableLiveData

    fun loadNews(query: String) {
        this.country = query
        disposables.add(
            dataManager.getNewsList(query, APIKEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext {
                    println(it.size)
                }
                .subscribe { result -> onRetrieveNewsListSuccess(result as List<News>) }
        )
    }

    fun onNewsClick(articleViewModel: ArticleViewModel) {
        urlMutableLiveData.value = articleViewModel.articleLink.value
    }

    override fun onCleared() {
        disposables.clear()
    }

    private fun onRetrieveNewsListSuccess(newsList:List<News>) {
        newsListAdapter.updateNewsList(newsList)
    }

    companion object {
        private val APIKEY = "a1bcf426f1c44d9caf08322ac46b9e5e"
    }
}