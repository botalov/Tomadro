package com.test.botalov.tomadro.main.timer.view

import android.support.v4.app.FragmentActivity


interface ITimerView {

    fun updateTime(time: Int)
    fun showMessage(message: String)
    fun initWorkedState()
    fun initStoppedState()
    fun initPausedState()
    fun getContextActivity(): FragmentActivity
    fun updateCurrentTask()
}