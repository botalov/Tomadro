package com.test.botalov.tomadro.main.timer.view.TimerSkins

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.test.botalov.tomadro.R
import com.test.botalov.tomadro.main.timer.presenter.TimerPresenter
import com.test.botalov.tomadro.main.timer.view.ITimerView

class SimpleDigitalTimerFragment: Fragment(), ITimerView {
    val presenter = TimerPresenter()

    private var currentTimeTextView: TextView? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?)
            : View? {
        val view = inflater.inflate(R.layout.fragment_simple_digital_timer, container, false)
        initViews(view)
        presenter.attachView(this)

        return view
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()
    }

    private fun initViews(view: View) {
        currentTimeTextView = view.findViewById(R.id.currentSessionTimeTextView)

        val startStopButton = view.findViewById<Button>(R.id.startStopButton)
        startStopButton.setOnClickListener {
            presenter.onStart()
        }
    }

    override fun updateTime(time: Int) {
        currentTimeTextView?.text = time.toString()
    }

    override fun showMessage(message: String) {

    }

    override fun initWorkedState() {

    }

    override fun initPausedState() {

    }

    override fun initStoppedState() {

    }

    override fun getContextActivity(): FragmentActivity {
        return activity!!
    }

    override fun updateCurrentTask() {

    }
}