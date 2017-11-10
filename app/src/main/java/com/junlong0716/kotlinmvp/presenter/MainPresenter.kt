package com.junlong0716.kotlinmvp.presenter

import com.junlong0716.kotlinmvp.callback.MvpCallback
import com.junlong0716.kotlinmvp.model.MainModel
import com.junlong0716.kotlinmvp.view.IMainView
import com.junlong0716.mvpbaselibrary.BasePresenter
import com.junlong0716.mvpbaselibrary.Callback
import java.util.*

/**
 *@author: 巴黎没有摩天轮Li
 *@description:
 *@date: Created in 上午11:19 2017/11/10
 *@modified by:
 */
class MainPresenter : BasePresenter<IMainView>() {

    override fun onDestroyPresenter() {

        if (!isViewAttached()) return

        MainModel.destroyRequest()

    }

    fun getData(key: String, stockNum: String) {

        if (!isViewAttached()) return

        MainModel.getNetData(key,stockNum,object : MvpCallback<String>{
            override fun onSuccess(data: String) {
                getView()!!.showData(data)
            }

            override fun onFailure(msg: String) {
                getView()!!.showErr()
            }

            override fun onError() {
                getView()!!.showErr()
            }

            override fun onComplete() {

            }

        })
    }



}