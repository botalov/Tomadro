package com.test.botalov.tomadro.main.timer.presenter

import android.content.Intent
import com.test.botalov.tomadro.main.timer.RES_CODE
import com.test.botalov.tomadro.main.timer.view.ITimerView
import com.test.botalov.tomadro.services.TimerService

class TimerPresenter: ITimerPresenter {
    override fun onGoToTasks() {

    }

    override fun onGoToSettings() {

    }

    private var view: ITimerView? = null
    override fun attachView(view: ITimerView) {
        this.view = view
    }

    override fun detachView() {
        this.view = null
    }

    override fun onTick(tick: Int) {
        view?.updateTime(tick)
    }

    override fun onStart() {
        val intent = Intent(view?.getContextActivity(), TimerService::class.java)
        val pendingIntent = view?.getContextActivity()?.createPendingResult(RES_CODE, intent, 0)
        intent.putExtra(TimerService.PENDING_ARG, pendingIntent)
        view?.getContextActivity()?.startService(intent)
    }

    override fun onStop() {

    }

    override fun onPause() {

    }

}