package com.macgavrina.trinitydigitalusers.presenters

import android.util.Log
import com.macgavrina.trinitydigitalusers.interfaces.UsersListContract
import com.macgavrina.trinitydigitalusers.model.User
import com.macgavrina.trinitydigitalusers.rest_services.GetUsersService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class UsersListPresenter: BasePresenter<UsersListContract.View>(), UsersListContract.Presenter {

    override fun viewIsReady() {
        getView()?.showProgress()


        val getUsersService: GetUsersService = GetUsersService.create()

        getUsersService.performGetCall()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<List<User>>() {
                    override fun onSuccess(t: List<User>) {
                        Log.d("MyApp", "success")
                        Log.d("MyApp", t.toString())
                        getView()?.updateUsersList(t)
                        getView()?.hideProgress()
                    }

                    override fun onError(e: Throwable) {
                        Log.d("MyApp", "error = ${e.message}")
                        getView()?.hideProgress()
                        getView()?.showError("Error: ${e.message}")
                    }
                })
    }



}