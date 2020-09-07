package com.chirag.randompeoplecarouseltest.ui.adapter

import android.content.Context
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
class FavouritePeopleAdapter(
    private val favouriteList: List<User>,
    private val context: Context,
    private val itemClicked: (User) -> Unit
) : RecyclerView.Adapter<FavouritePeopleAdapter.FavouritePeopleViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavouritePeopleViewHolder {
        val view =
            LayoutInflater.from(context).inflate(R.layout.favourite_people_list_item, parent, false)
        return FavouritePeopleViewHolder(view, itemClicked)
    }

    override fun onBindViewHolder(holder: FavouritePeopleViewHolder, position: Int) {
        holder.bindUser(context, favouriteList[position])
    }

    override fun getItemCount(): Int {
        return favouriteList.size
    }

    inner class FavouritePeopleViewHolder(itemView: View, val itemClicked: (User) -> Unit) :
        RecyclerView.ViewHolder(itemView) {

        private val userProfileIv: ImageView = itemView.findViewById(R.id.profile_iv)
        private val userNameTextView: TextView = itemView.findViewById(R.id.user_name)
        private val userPhoneNumberTextView: TextView =
            itemView.findViewById(R.id.user_phone_number)

        fun bindUser(context: Context, user: User) {
            with(user) {
                Glide.with(context)
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
}