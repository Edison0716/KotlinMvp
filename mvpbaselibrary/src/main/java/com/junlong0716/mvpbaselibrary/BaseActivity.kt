package com.junlong0716.mvpbaselibrary

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast

/**
 *@author: 巴黎没有摩天轮Li
 *@description:
 *@date: Created in 上午10:38 2017/11/10
 *@modified by:
 */
abstract class BaseActivity : AppCompatActivity(), IBaseView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(setContentLayout())
        attachPresenter()
        doBusiness(savedInstanceState)
    }

    abstract fun setContentLayout(): Int

    //业务逻辑
    abstract fun doBusiness(savedInstanceState: Bundle?)

    //绑定Presenter
    abstract fun attachPresenter()

    override fun showToast(msg: String) {
        Toast.makeText(applicationContext,msg,Toast.LENGTH_SHORT).show()
    }

    override fun showErr() {
        showToast(resources.getString(R.string.api_error_msg))
    }

    override fun showLoading() {
    }

    override fun hideLoading() {
    }

}