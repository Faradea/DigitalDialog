package com.macgavrina.trinitydigitalusers.presenters

import android.util.Log
import com.macgavrina.trinitydigitalusers.interfaces.MainActivityContract
import com.macgavrina.trinitydigitalusers.model.User
import com.macgavrina.trinitydigitalusers.rest_services.GetUsersService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class MainActivityPresenter:BasePresenter<MainActivityContract.View>(), MainActivityContract.Presenter {

    override fun viewIsReady() {
        getView()?.displayUsersListFragment()
    }
}