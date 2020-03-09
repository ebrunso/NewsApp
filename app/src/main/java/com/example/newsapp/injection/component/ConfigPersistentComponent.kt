package com.example.newsapp.injection.component

import com.example.newsapp.injection.ConfigPersistent
import com.example.newsapp.injection.module.ActivityModule
import com.example.newsapp.injection.module.FragmentModule
import dagger.Component


@ConfigPersistent
@Component(dependencies = [AppComponent::class])
interface ConfigPersistentComponent {

    fun activityComponent(activityModule: ActivityModule): ActivityComponent

    fun fragmentComponent(fragmentModule: FragmentModule): FragmentComponent

}
