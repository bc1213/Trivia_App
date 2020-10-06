package com.trivia.android

import android.app.Application
import com.trivia.android.core.db.TriviaDatabase

class AppConfig: Application() {

    var mAppConfig: AppConfig? = null

    override fun onCreate() {
        super.onCreate()
        mAppConfig = this

        initializeDataBase()
    }

    companion object {
        fun getAppVersion():Int {
            return BuildConfig.VERSION_CODE
        }
    }

    fun initializeDataBase() {
        TriviaDatabase.initDatabase(this)
    }

}