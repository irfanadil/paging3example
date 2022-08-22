package com.demo.characterdemoapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class CharacterApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        //Logger.addLogAdapter(AndroidLogAdapter())
        //if (BuildConfig.DEBUG)
            Timber.plant(Timber.DebugTree())

    }

}