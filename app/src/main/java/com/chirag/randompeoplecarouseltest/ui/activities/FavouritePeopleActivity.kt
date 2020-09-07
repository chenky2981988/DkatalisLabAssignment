package com.chirag.randompeoplecarouseltest.ui.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.chirag.randompeoplecarouseltest.R
import com.chirag.randompeoplecarouseltest.model.User
import com.chirag.randompeoplecarouseltest.ui.adapter.FavouritePeopleAdapter
import com.chirag.randompeoplecarouseltest.viewmodel.FavouriteViewModel
import com.chirag.randompeoplecarouseltest.viewmodel.FavouriteViewModelFactory
import com.mindorks.butterknifelite.ButterKnifeLite
import com.mindorks.butterknifelite.annotations.BindView

//Activity to display favourite people list from database
class FavouritePeopleActivity : AppCompatActivity() {

    @BindView(R.id.progressBar)
    lateinit var progressBar: ProgressBar

    @BindView(R.id.favourite_people_rv)
    lateinit var recyclerView: RecyclerView

    @BindView(R.id.no_favourite_people)
    lateinit var noFavouritePeople: TextView


    private val favouriteViewModel: FavouriteViewModel by lazy {
        ViewModelProvider(this, FavouriteViewModelFactory(applicationContext)).get(
            FavouriteViewModel::class.java
        )
    }
    private lateinit var favouritePeopleAdapter: FavouritePeopleAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favourite_people)
        ButterKnifeLite.bind(this)
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        getFavouritePeopleList()
    }

    private fun getFavouritePeopleList() {
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                recyclerView.context,
                DividerItemDecoration.VERTICAL
            )
        )
        showProgressBar()
        //Observe Favourite people list from Database
        favouriteViewModel.getListOfFavouritePeople()?.observe(this, Observer {
            it?.let {
                if (it.isNotEmpty()) {
                    noFavouritePeople.visibility = View.GONE
                    recyclerView.visibility = View.VISIBLE
                    favouritePeopleAdapter = FavouritePeopleAdapter(it) { it1 ->
                        onUserSelected(it1)
                    }
                    recyclerView.adapter = favouritePeopleAdapter
                } else {
                    noFavouritePeople.visibility = View.VISIBLE
                    recyclerView.visibility = View.GONE
                }
            }
            hideProgressBar()
        })
    }

    //Change progressbar visibility and disable screen touch
    private fun showProgressBar() {
        progressBar.visibility = View.VISIBLE
        window?.setFlags(
            WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
            WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE
        )
    }

    //Change progressbar visibility and enable screen touch
    private fun hideProgressBar() {
        progressBar.visibility = View.GONE
        window?.clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
    }

    //Override interface method on User tab from list
    private fun onUserSelected(user: User) {
        Log.d("TAG", "Selected user : ${user.name.first}")
        val profileViewIntent = Intent(this, ProfileViewActivity::class.java)
        profileViewIntent.putExtra("user", user)
        startActivity(profileViewIntent)
    }
}