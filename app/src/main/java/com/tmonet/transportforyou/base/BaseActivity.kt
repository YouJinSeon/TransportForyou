package com.tmonet.transportforyou.base

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.tmonet.transportforyou.utils.NetworkState


open class BaseActivity : AppCompatActivity(){
    private val logTag: String = this.javaClass.simpleName
    private var networkState: NetworkState? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        networkState = NetworkState(this)
        networkState?.register()
    }

    override fun onResume() {
        super.onResume()

        /*when (ActivityLifecycleManager.getInstance(this).appStatus) {
            // 앱의 상태가 백그라운드 -> 포그라운드 시
            AppStatus.RETURNED_TO_FOREGROUND -> {
                try {

                } catch (e: Exception) {

                }
            }

            else -> {

            }
        }*/
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        networkState?.unregister()
    }

    override fun onRestart() {
        super.onRestart()
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when (requestCode) {

        }
    }
}