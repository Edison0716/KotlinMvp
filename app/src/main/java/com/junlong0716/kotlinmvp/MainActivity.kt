package com.junlong0716.kotlinmvp

import android.content.Context
import android.os.Bundle
import com.junlong0716.kotlinmvp.constant.KeyConstant
import com.junlong0716.kotlinmvp.presenter.MainPresenter
import com.junlong0716.kotlinmvp.view.IMainView
import com.junlong0716.mvpbaselibrary.BaseActivity


class MainActivity : BaseActivity(), IMainView {
    override fun showData(data: String) {
        showToast(data)
    }

    private var mainPresenter: MainPresenter? = null;

    override fun attachPresenter() {
        mainPresenter = MainPresenter()
        mainPresenter!!.attachView(this)
    }


    override fun getContext(): Context {
        return this
    }

    override fun setContentLayout(): Int {
        return R.layout.activity_main
    }

    override fun doBusiness(savedInstanceState: Bundle?) {
        mainPresenter!!.getData(KeyConstant.JH_API_KEY, "sz002375")
        testLeak()
    }

    override fun onDestroy() {
        super.onDestroy()
        mainPresenter!!.onDestroyPresenter()
        mainPresenter!!.detachView()

        val refWatcher = MyApplication.application!!.getRefWatcher()

        refWatcher.watch(this)
    }

    /**
     * 测试内存泄漏的代码
     */
    private fun testLeak() {
        Thread(Runnable {
            while (true) {
                try {
                    Thread.sleep(1000)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }

            }
        }).start()
    }
}
