package com.macgavrina.trinitydigitalusers.views

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.macgavrina.trinitydigitalusers.MainApplication
import com.macgavrina.trinitydigitalusers.R
import com.macgavrina.trinitydigitalusers.adapters.UsersRecyclerViewAdapter
import com.macgavrina.trinitydigitalusers.interfaces.UsersListContract
import com.macgavrina.trinitydigitalusers.model.User
import com.macgavrina.trinitydigitalusers.presenters.UsersListPresenter
import kotlinx.android.synthetic.main.users_list_fragment.*

class UsersListFragment: Fragment(), UsersListContract.View {

    lateinit var presenter: UsersListPresenter
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun updateUsersList(usersList: List<User>) {
        Log.d("MyApp", "UsersListFragment: update users list method")

        users_list_fragment_recycler_view.adapter = UsersRecyclerViewAdapter(usersList)
        users_list_fragment_recycler_view.layoutManager = viewManager

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        presenter = UsersListPresenter()
        presenter.attachView(this)

        return inflater.inflate(R.layout.users_list_fragment, container,
                false)
    }


    override fun onResume() {
        super.onResume()

        viewManager = LinearLayoutManager(MainApplication.applicationContext())
        users_list_fragment_recycler_view.adapter = UsersRecyclerViewAdapter(null)
        users_list_fragment_recycler_view.layoutManager = viewManager

        presenter.viewIsReady()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.detachView()
    }

    override fun showProgress() {
        users_list_fragment_progress_bar.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        users_list_fragment_progress_bar.visibility = View.INVISIBLE
    }

    override fun showError(text: String) {
        Toast.makeText(MainApplication.applicationContext(), text, Toast.LENGTH_SHORT).show()
    }

}