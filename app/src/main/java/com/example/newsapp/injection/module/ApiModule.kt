package com.example.newsapp.injection.module

import com.example.newsapp.features.newsloading.data.service.NewsService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module(includes = [NetworkModule::class])
class ApiModule {

    @Provides
    @Singleton
    internal fun provideNewsApi(retrofit: Retrofit): NewsService {
        return retrofit.create(NewsService::class.java)
    }

}