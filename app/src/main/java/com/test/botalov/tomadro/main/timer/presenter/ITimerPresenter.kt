package com.test.botalov.tomadro.main.timer.presenter

import com.test.botalov.tomadro.main.timer.view.ITimerView

interface ITimerPresenter {
    fun attachView(view: ITimerView)
    fun detachView()

    fun onTick(tick: Int)
    fun onStart()
    fun onStop()
    fun onPause()

    fun onGoToTasks()
    fun onGoToSettings()
}