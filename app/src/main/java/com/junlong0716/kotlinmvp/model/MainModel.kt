package com.junlong0716.kotlinmvp.model

import android.util.Log
import com.junlong0716.kotlinmvp.callback.MvpCallback
import com.junlong0716.kotlinmvp.http.StockApi
import com.junlong0716.retrofitutils.RetrofitUtils
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.annotations.NonNull
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import okhttp3.ResponseBody
import java.util.concurrent.TimeUnit

/**
 *@author: 巴黎没有摩天轮Li
 *@description:
 *@date: Created in 上午11:26 2017/11/10
 *@modified by:
 */
object MainModel : BaseModel() {
    private lateinit var subscribe: Disposable;
    private lateinit var d: Disposable

    override fun destroyRequest() {
        d!!.dispose()
        subscribe!!.dispose()
    }


    /**
     * 获取网络接口数据
     * @param param 请求参数
     * @param callback 数据回调接口
     */
    fun getNetData(key: String, stockNum: String, callback: MvpCallback<String>) {
        subscribe = Observable.interval(2, 2, TimeUnit.SECONDS).subscribe { aLong ->
            RetrofitUtils.createService<StockApi>(StockApi::class.java)
                    .getStockInfo(key, /*"sz002375"*/stockNum)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(object : Observer<ResponseBody> {

                        override fun onSubscribe(@NonNull d: Disposable) {
                            MainModel.d = d
                        }

                        override fun onNext(@NonNull body: ResponseBody) {
                            callback.onSuccess(body.string())
                        }

                        override fun onError(@NonNull e: Throwable) {
                            callback.onError()
                            Log.d("onError", e.message)
                        }

                        override fun onComplete() {
                            callback.onComplete()
                        }
                    })
        }

    }

}