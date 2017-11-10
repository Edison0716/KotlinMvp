package com.junlong0716.mvpbaselibrary

import android.content.Context

/**
 *@author: 巴黎没有摩天轮Li
 *@description: view层 基类
 *@date: Created in 上午10:33 2017/11/10
 *@modified by:
 */
interface IBaseView {
    /**
     * 显示正在加载view
     */
    fun showLoading()

    /**
     * 关闭正在加载view
     */
    fun hideLoading()

    /**
     * 显示提示
     * @param msg
     */
    fun showToast(msg: String)

    /**
     * 显示请求错误提示
     */
    fun showErr()

    /**
     * 获取上下文
     * @return 上下文
     */
    fun getContext(): Context
}