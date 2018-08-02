package com.macgavrina.trinitydigitalusers.interfaces

import com.macgavrina.trinitydigitalusers.model.User

interface UsersListContract {

    interface View:BaseViewContract {

        fun showProgress()

        fun hideProgress()

        fun updateUsersList(usersList: List<User>)

        fun showError(text: String)

    }

    interface Presenter:BasePresenterContract<View> {

    }

}