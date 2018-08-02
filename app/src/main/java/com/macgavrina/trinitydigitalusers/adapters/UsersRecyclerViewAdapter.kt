package com.macgavrina.trinitydigitalusers.adapters

import android.annotation.SuppressLint
import android.content.res.Resources
import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.macgavrina.trinitydigitalusers.R
import com.macgavrina.trinitydigitalusers.model.User
import kotlinx.android.synthetic.main.user_list_item.view.*

class UsersRecyclerViewAdapter (usersList: List<User>?) :
        RecyclerView.Adapter<UsersRecyclerViewAdapter.ViewHolder>() {

    private val mItems: List<User>? = usersList

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder.
    // Each data item is just a string in this case that is shown in a TextView.
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val similarityTV = view.user_list_item_similarity_tv
        val nameTV = view.user_list_item_name_tv
        val ageTV = view.user_list_item_age_tv
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): UsersRecyclerViewAdapter.ViewHolder {
        val layoutInflater: LayoutInflater = LayoutInflater.from(parent.context)
        // create a new view
        val view = layoutInflater.inflate(R.layout.user_list_item, parent, false)
        // set the view's size, margins, paddings and layout parameters
        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    @SuppressLint("ResourceAsColor")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        Log.d("MyApp", "Bind item with position = ${position}")
        val item = mItems?.get(position)
        holder.nameTV.text = item?.name
        holder.ageTV.text = item?.age.toString()
        holder.similarityTV.text = item?.similarity.toString()
        when (item?.similarity){
            in 0..40 -> holder.similarityTV.setTextColor(Color.RED)
            in 41..70 -> holder.similarityTV.setTextColor(Color.YELLOW)
            in 70..100 -> holder.similarityTV.setTextColor(Color.GREEN)
        }

    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount(): Int {
        if (mItems != null) {
            return mItems.size
        }
        return -1
    }

}