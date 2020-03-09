package com.example.newsapp.injection.component

import android.app.Application
import android.content.Context
import com.example.newsapp.features.newsloading.data.DataManager
import com.example.newsapp.injection.ApplicationContext
import com.example.newsapp.injection.module.AppModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

    @ApplicationContext
    fun context(): Context

    fun application(): Application

    fun apiManager(): DataManager

}