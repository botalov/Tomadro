package com.test.botalov.tomadro.services

import android.app.PendingIntent
import android.content.Intent
import android.util.Log
import com.test.botalov.tomadro.app.TomadroApp
import java.util.concurrent.TimeUnit

class TimerRunnable(val time: Int, private val pendingIntent: PendingIntent) : Runnable {
    private val LOG_TAG = "myLogs"
    override fun run() {
        for(i in 1..time) {
            try {
                TimeUnit.SECONDS.sleep(1)
                val intent = Intent()
                intent.putExtra(TimerService.VALUE_TICK_ARG, i)
                pendingIntent.send(TomadroApp.applicationContext(), TimerService.STATUS_TICK, intent)
                Log.d(LOG_TAG, i.toString())
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
        }
    }
}