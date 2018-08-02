package com.macgavrina.trinitydigitalusers.interfaces

interface MainActivityContract {

    interface View:BaseViewContract {

        fun displayUsersListFragment()

    }

    interface Presenter:BasePresenterContract<View> {

    }

}