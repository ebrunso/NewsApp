package com.example.newsapp.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.newsapp.features.newsloading.data.DataManager
import com.example.newsapp.features.newsloading.viewmodel.NewsViewModel
import javax.inject.Inject

class ViewModelFactory @Inject
constructor(private val dataManager: DataManager) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass == NewsViewModel::class.java) return NewsViewModel(dataManager) as T
        throw RuntimeException("Cannot create an instance of $modelClass", ClassNotFoundException
            ("Class not supported in ViewModelFactory"))
    }
}