package com.example.newsapp.injection.component

import com.example.newsapp.features.newsloading.view.MainActivity
import com.example.newsapp.injection.PerActivity
import com.example.newsapp.injection.module.ActivityModule
import dagger.Subcomponent

@PerActivity
@Subcomponent(modules = [ActivityModule::class])
interface ActivityComponent {
    fun inject(mainActivity: MainActivity)
}