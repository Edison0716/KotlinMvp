package com.junlong0716.kotlinmvp.model

import io.reactivex.disposables.Disposable

/**
 *@author: 巴黎没有摩天轮Li
 *@description:
 *@date: Created in 下午2:13 2017/11/10
 *@modified by:
 */
abstract class BaseModel {
    abstract fun destroyRequest()
}