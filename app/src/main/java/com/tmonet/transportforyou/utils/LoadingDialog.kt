package com.tmonet.transportforyou.utils


import android.app.ProgressDialog
import android.content.Context
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatDialog
import com.tmonet.transportforyou.R

/**
 * 로딩 뷰
 */
class LoadingDialog(context: Context) : AppCompatDialog(context, R.style.DialogStyle_Loading) {
    private var animationDrawable: AnimationDrawable? = null
    lateinit var progressDialog: ProgressDialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_loading)
        setCancelable(false)

        animationDrawable =
            (findViewById<ImageView>(R.id.iv_loading)?.background) as AnimationDrawable
    }

    /**
     * 로딩 뷰 보이기
     */
    override fun show() {
        super.show()
        animationDrawable?.start()
    }

    /**
     * 로딩 뷰 숨기기
     */
    override fun dismiss() {
        super.dismiss()
        animationDrawable?.stop()
    }
}