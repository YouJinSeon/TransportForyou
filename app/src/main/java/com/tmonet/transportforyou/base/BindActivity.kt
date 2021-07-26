package com.tmonet.transportforyou.base

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BindActivity<B : ViewDataBinding> : BaseActivity() {
    protected lateinit var b: B

    /**
     * setContentView로 호출할 Layout의 리소스 id.
     * ex) R.layout.activity_main
     */
    protected abstract val layoutId: Int

    /**
     * 레이아웃을 띄운 직후 호출.
     * 뷰나 액티비티의 속성 등을 초기화.
     * ex) 리사이클러뷰, 툴바, 드로어뷰..
     */
    abstract fun initStartView()

    /**
     * 두번째로 호출.
     * 데이터 바인딩 및 rxjava 설정.
     * ex) rxjava observe, databinding observe..
     */
    abstract fun initDataBinding()

    /**
     * 바인딩 이후에 할 일을 여기에 구현.
     * 그 외에 설정할 것이 있으면 이곳에서 설정.
     * 클릭 리스너도 이곳에서 설정.
     */
    abstract fun initAfterBinding()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        b = DataBindingUtil.setContentView(this, layoutId)

        initStartView()
        initDataBinding()
        initAfterBinding()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    open fun onClicks(view: View) {

    }
}