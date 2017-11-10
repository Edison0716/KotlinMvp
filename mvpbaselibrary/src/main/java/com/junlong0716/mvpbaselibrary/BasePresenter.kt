package com.junlong0716.mvpbaselibrary


/**
 *@author: 巴黎没有摩天轮Li
 *@description: presenter层 基类
 *@date: Created in 上午10:34 2017/11/10
 *@modified by:
 */
abstract class BasePresenter<V : IBaseView> {
    /**
     * 绑定的view
     */
    private var mvpView: V? = null

    /**
     * 绑定view，一般在初始化中调用该方法
     */
    fun attachView(mvpView: V) {
        this.mvpView = mvpView
    }

    /**
     * 断开view，一般在onDestroy中调用
     */
    fun detachView() {
        this.mvpView = null
    }

    /**
     * 是否与View建立连接
     * 每次调用业务请求的时候都要出先调用方法检查是否与View建立连接
     */
    fun isViewAttached(): Boolean {
        return mvpView != null
    }

    /**
     * 获取连接的view
     */
    fun getView(): V? {
        return mvpView
    }

    abstract fun onDestroyPresenter()
}