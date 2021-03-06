package com.example.newsapp.injection.module

import android.app.Activity
import android.content.Context
import androidx.fragment.app.Fragment
import com.example.newsapp.injection.ActivityContext
import dagger.Module
import dagger.Provides

@Module
class FragmentModule(private val fragment: Fragment) {

    @Provides
    internal fun providesFragment(): Fragment {
        return fragment
    }

    @Provides
    internal fun provideActivity(): Activity? {
        return fragment.activity
    }

    @Provides
    @ActivityContext
    internal fun providesContext(): Context? {
        return fragment.activity
    }
}