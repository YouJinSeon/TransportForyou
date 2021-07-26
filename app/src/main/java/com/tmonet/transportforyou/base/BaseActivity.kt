package com.tmonet.transportforyou.base

import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDialog
import com.tmonet.transportforyou.R
import com.tmonet.transportforyou.utils.NetworkState


open class BaseActivity : AppCompatActivity(){
    private val logTag: String = this.javaClass.simpleName
    private var networkState: NetworkState? = null
    var pd: AppCompatDialog? = null
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

    fun showLoading() {
        if (!this.isFinishing) {
            runOnUiThread {
                if (pd == null) {
                    pd = AppCompatDialog(this)
                    pd!!.window!!.setBackgroundDrawableResource(android.R.color.transparent)
                    pd!!.setContentView(R.layout.progress_loading)
                    pd!!.setCancelable(false)

                    val img_loading_frame = pd!!.findViewById<ImageView>(R.id.iv_frame_loading)
                    val frameAnimation = img_loading_frame?.getBackground() as AnimationDrawable
                    img_loading_frame?.post(Runnable { frameAnimation.start() })
                    if (!this.isFinishing) pd!!.show()

                } else {
                    if (pd != null)
                        pd!!.show()
                }
            }
        }
    }

    fun hideLoading() {
        if (!this.isFinishing) {
            runOnUiThread {
                if (pd != null)
                    pd!!.dismiss()
            }
        }
    }
}