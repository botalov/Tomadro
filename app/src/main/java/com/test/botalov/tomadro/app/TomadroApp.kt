package com.test.botalov.tomadro.app

import android.app.Application
import android.content.Context

class TomadroApp : Application() {
    init {
        instance = this
    }

    companion object {
        private var instance: TomadroApp? = null

        fun applicationContext() : Context {
            return instance!!.applicationContext
        }
    }
}