package com.macgavrina.trinitydigitalusers.interfaces

public interface BasePresenterContract<V : BaseViewContract> {

    fun attachView(baseViewContract: V)

    fun viewIsReady()

    fun detachView()

    fun destroy()
}