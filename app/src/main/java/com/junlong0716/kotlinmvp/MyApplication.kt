package com.junlong0716.kotlinmvp

import android.app.Application
import android.content.Context
import android.util.Log
import com.junlong0716.retrofitutils.BaseRetrofitClient
import com.squareup.leakcanary.LeakCanary
import com.squareup.leakcanary.RefWatcher
import com.squareup.leakcanary.LeakCanary.refWatcher


/**
 *@author: 巴黎没有摩天轮Li
 *@description:
 *@date: Created in 下午12:49 2017/11/10
 *@modified by:
 */
class MyApplication : Application() {

    private var refWatcher: RefWatcher? = null

    fun getRefWatcher(): RefWatcher {
        return refWatcher!!
    }

    companion object {
        var application: MyApplication? = null
            private set
    }

    override fun onCreate() {
        super.onCreate()
        application = this
        BaseRetrofitClient.getInstance().setBaseUrl("http://web.juhe.cn:8080/").init(this)

        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            Log.e("leak", "内存泄漏了")
            return;
        }

        refWatcher = LeakCanary.install(this)
    }
}