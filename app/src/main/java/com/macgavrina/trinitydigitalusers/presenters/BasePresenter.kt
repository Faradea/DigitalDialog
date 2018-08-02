package com.macgavrina.trinitydigitalusers.presenters

import com.macgavrina.trinitydigitalusers.interfaces.BasePresenterContract
import com.macgavrina.trinitydigitalusers.interfaces.BaseViewContract

abstract class BasePresenter<T : BaseViewContract> : BasePresenterContract<T> {

    private var view: T? = null

    override fun attachView(baseViewContract: T) {
        view = baseViewContract
    }

    override fun detachView() {
        view = null
    }

    fun getView(): T? {
        return view
    }

    protected fun isViewAttached(): Boolean {
        return view != null
    }

    override fun destroy() {

    }
}