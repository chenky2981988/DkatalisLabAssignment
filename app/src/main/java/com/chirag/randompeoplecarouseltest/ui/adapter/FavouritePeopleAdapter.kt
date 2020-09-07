package com.chirag.randompeoplecarouseltest.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.chirag.randompeoplecarouseltest.R
import com.chirag.randompeoplecarouseltest.model.User


/**
 * Created by Chirag Sidhiwala on 6/9/20.
 */
//Adapter to bind data with favourite people list items.
class FavouritePeopleAdapter(
    private val favouriteList: List<User>,
    private val itemClicked: (User) -> Unit
) : RecyclerView.Adapter<FavouritePeopleAdapter.FavouritePeopleViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavouritePeopleViewHolder {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.favourite_people_list_item, parent, false)
        return FavouritePeopleViewHolder(view, itemClicked)
    }

    override fun onBindViewHolder(holder: FavouritePeopleViewHolder, position: Int) {
        holder.bindUser(favouriteList[position])
    }

    override fun getItemCount(): Int {
        return favouriteList.size
    }

    class FavouritePeopleViewHolder(itemView: View, val itemClicked: (User) -> Unit) :
        RecyclerView.ViewHolder(itemView) {

        private val userProfileIv: ImageView = itemView.findViewById(R.id.profile_iv)
        private val userNameTextView: TextView = itemView.findViewById(R.id.user_name)
        private val userPhoneNumberTextView: TextView =
            itemView.findViewById(R.id.user_phone_number)

        //Bind User object with each list item
        fun bindUser(user: User) {
            Glide.with(userProfileIv.context)
                .load(user.picture)
                .centerCrop()
                .placeholder(R.drawable.ic_profile_user)
                .into(userProfileIv)

            val displayName = "${user.name.first} ${user.name.last}"
            userNameTextView.text = displayName
            userPhoneNumberTextView.text = user.cell

            itemView.setOnClickListener { itemClicked(user) }

        }
    }
}