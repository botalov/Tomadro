package com.test.botalov.tomadro.main.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.test.botalov.tomadro.R
import com.test.botalov.tomadro.main.timer.presenter.TimerPresenter
import com.test.botalov.tomadro.services.TimerService
import com.test.botalov.tomadro.main.timer.view.TimerSkins.SimpleDigitalTimerFragment


class MainActivity : AppCompatActivity() {
    private var timerPresenter: TimerPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initFragments()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        val result = data!!.getIntExtra(TimerService.VALUE_TICK_ARG, 0)
        timerPresenter?.onTick(result)
       // currentTimeTextView.text = result.toString()

    }

    private fun initFragments(){
        val timerFragment = SimpleDigitalTimerFragment()
        timerPresenter = timerFragment.presenter
        supportFragmentManager.beginTransaction()
                .replace(R.id.timerFrameLayout, timerFragment, "timerFragment")
                .commit()
    }
}
