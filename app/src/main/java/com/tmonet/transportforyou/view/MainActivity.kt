package com.tmonet.transportforyou.view

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.tmonet.transportforyou.R
import com.tmonet.transportforyou.base.BindActivity
import com.tmonet.transportforyou.databinding.ActivityMainBinding

class MainActivity : BindActivity<ActivityMainBinding>() {
    override val layoutId = R.layout.activity_main
    val TAG = "MainActivity"
    private var onBackPressedTime = 0L
    private var mContext : Context? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG,"onCreate@@@@@@@@")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG,"onResume@@@@@@@@")
    }

    override fun initStartView() {
        initView()
        initValue()
    }

    override fun initDataBinding() {}

    override fun initAfterBinding() {}

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG,"onDestory@@@@@@@@")
    }

    fun initView() {

    }

    fun initValue() {
        mContext = this
    }

    override fun onBackPressed() {
        val tempTime = System.currentTimeMillis()
        when (tempTime - onBackPressedTime) {
            in 0..2000 -> {
                super.onBackPressed()
                finish()
            }
            else -> {
                onBackPressedTime = tempTime
                Toast.makeText(mContext, "뒤로 버튼을 한 번 더 누르시면 종료됩니다", Toast.LENGTH_SHORT).show()
            }
        }
    }

}
