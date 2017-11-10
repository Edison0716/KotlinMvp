package com.junlong0716.kotlinmvp.http

import io.reactivex.Observable
import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Query

/**
 *@author: 巴黎没有摩天轮Li
 *@description:
 *@date: Created in 下午12:57 2017/11/10
 *@modified by:
 */
interface StockApi {
    //获取信息
    @GET("finance/stock/hs")
    fun getStockInfo(@Query("key") key: String, @Query("type") type: Int): Observable<ResponseBody>

    //获取信息
    @GET("finance/stock/hs")
    fun getStockInfo(@Query("key") key: String, @Query("gid") gid: String): Observable<ResponseBody>
}