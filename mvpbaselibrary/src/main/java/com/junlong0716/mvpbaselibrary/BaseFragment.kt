package com.junlong0716.mvpbaselibrary

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

/**
 *@author: 巴黎没有摩天轮Li
 *@description:
 *@date: Created in 下午3:36 2017/11/10
 *@modified by:
 */
abstract class BaseFragment : Fragment(), IBaseView {
    private lateinit var v: View

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        v = inflater!!.inflate(setContentLayout(), container, false)
        doBusiness(v, savedInstanceState)
        return v
    }

    abstract fun doBusiness(v: View, savedInstanceState: Bundle?)

    abstract fun setContentLayout(): Int

    override fun hideLoading() {
        checkActivityAttached()
    }

    override fun showToast(msg: String) {
        checkActivityAttached()
        Toast.makeText(activity.applicationContext, msg, Toast.LENGTH_SHORT).show()
    }

    override fun showErr() {
        checkActivityAttached()
        showToast(resources.getString(R.string.api_error_msg))
    }

    override fun showLoading() {
        checkActivityAttached()
    }

    protected fun isAttachedContext(): Boolean {
        return activity != null
    }


    /**
     * 检查activity连接情况
     */
    private fun checkActivityAttached() {
        if (activity == null) {
            throw ActivityNotAttachedException()
        }
    }

    class ActivityNotAttachedException : RuntimeException("Fragment has disconnected from Activity !")
}
