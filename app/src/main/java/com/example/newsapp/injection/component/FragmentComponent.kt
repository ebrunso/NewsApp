package com.example.newsapp.injection.component

import com.example.newsapp.injection.PerFragment
import com.example.newsapp.injection.module.FragmentModule
import dagger.Subcomponent

@PerFragment
@Subcomponent(modules = [FragmentModule::class])
interface FragmentComponent {
}