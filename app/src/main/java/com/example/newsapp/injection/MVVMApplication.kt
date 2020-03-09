package com.example.newsapp.injection

import android.app.Application
import android.content.Context
import com.example.newsapp.R
import com.example.newsapp.injection.component.AppComponent
import com.example.newsapp.injection.module.ApiModule
import com.example.newsapp.injection.module.AppModule
import com.example.newsapp.injection.module.NetworkModule
import com.example.newsapp.injection.component.DaggerAppComponent

class MVVMApplication : Application() {

    var component: AppComponent? = null
        get() {
            val apiUrl = "https://newsapi.org"


            if (field == null) {
                component = DaggerAppComponent.builder()
                    .apiModule(ApiModule())
                    .networkModule(NetworkModule(applicationContext, apiUrl))
                    .appModule(AppModule(this))
                    .build()
            }
            return field
        }

    companion object {
        operator fun get(context: Context): MVVMApplication {
            return context.applicationContext as MVVMApplication
        }
    }

}