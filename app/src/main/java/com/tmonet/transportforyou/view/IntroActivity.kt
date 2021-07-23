package com.tmonet.transportforyou.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.tmonet.transportforyou.R
import com.tmonet.transportforyou.base.BindActivity
import com.tmonet.transportforyou.databinding.ActivityMainBinding
import io.reactivex.rxjava3.core.Completable
import java.util.concurrent.TimeUnit

class IntroActivity : BindActivity<ActivityMainBinding>()  {
    override val layoutId = R.layout.activity_intro
    val TAG = "IntroActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)

        Log.d(TAG,"onCreate@@@@@@@@")

    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG,"onResume@@@@@@@@")
    }

    override fun initStartView() {
        initView()
    }

    override fun initDataBinding() {}

    override fun initAfterBinding() {}

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG,"onDestory@@@@@@@@")
    }

    fun initView() {
        Completable.complete()
            .delay(2, TimeUnit.SECONDS)
            .doOnComplete {
                startMain()
            }
            .subscribe()
    }

    fun startMain() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        overridePendingTransition(R.anim.anim_slide_in_left, R.anim.hold)
        finish()
    }

}