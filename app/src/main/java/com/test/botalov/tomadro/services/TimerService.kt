package com.test.botalov.tomadro.services

import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.os.IBinder


class TimerService : Service() {

    companion object {
        val PARAM_RESULT = "PARAM_RESULT"
        val PENDING_ARG = "PENDING_ARG"
        val STATUS_TICK = 1
        val VALUE_TICK_ARG = "VALUE_TICK_ARG"
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val pendingIntent = intent!!.getParcelableExtra<PendingIntent>(PENDING_ARG)
        val runnable = TimerRunnable(1200, pendingIntent)
        Thread(runnable).start()
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onBind(p0: Intent?): IBinder? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        return null
    }
}