package com.chirag.randompeoplecarouseltest.ui.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.chirag.randompeoplecarouseltest.R
import com.chirag.randompeoplecarouseltest.model.User
import com.chirag.randompeoplecarouseltest.networking.ServerResponse
import com.chirag.randompeoplecarouseltest.swipecard.SwipeCardInterface
import com.chirag.randompeoplecarouseltest.swipecard.TinderProfileCard
import com.chirag.randompeoplecarouseltest.viewmodel.MainViewModel
import com.chirag.randompeoplecarouseltest.viewmodel.MainViewModelFactory
import com.mindorks.butterknifelite.ButterKnifeLite
import com.mindorks.butterknifelite.annotations.BindView
import com.mindorks.placeholderview.SwipeDecor
import com.mindorks.placeholderview.SwipePlaceHolderView
import com.mindorks.placeholderview.SwipeViewBuilder
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.InternalCoroutinesApi

@ExperimentalCoroutinesApi
@FlowPreview
@InternalCoroutinesApi
class MainActivity : AppCompatActivity(), SwipeCardInterface {

    @BindView(R.id.swipeView)
    lateinit var mSwipeView: SwipePlaceHolderView

    @BindView(R.id.progressBar)
    lateinit var progressBar: ProgressBar

    @BindView(R.id.favourite_button)
    lateinit var favouriteButton: Button

    private val mainViewModel: MainViewModel by lazy {
        ViewModelProvider(
            this,
            MainViewModelFactory(applicationContext)
        ).get(MainViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ButterKnifeLite.bind(this)

        initListener()
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)

        mSwipeView.getBuilder<SwipePlaceHolderView, SwipeViewBuilder<SwipePlaceHolderView>>()
            //                .setSwipeType(SwipePlaceHolderView.SWIPE_TYPE_VERTICAL)
            .setDisplayViewCount(3)
            .setIsUndoEnabled(true)
            .setWidthSwipeDistFactor(4f)
            .setHeightSwipeDistFactor(6f)
            .setSwipeDecor(
                SwipeDecor()
                    //                        .setMarginTop(300)
                    //                        .setMarginLeft(100)
                    //                        .setViewGravity(Gravity.TOP)
                    .setPaddingTop(20)
                    .setSwipeMaxChangeAngle(2f)
                    .setRelativeScale(0.01f)
            )

        favouriteButton.setOnClickListener {
            /*mainViewModel.getListOfFavouritePeople()?.observe(this, Observer {
                Log.d("TAG","list size : " + it.size)
            })*/
            val favouriteListIntent = Intent(this, FavouritePeopleActivity::class.java)
            startActivity(favouriteListIntent)
        }

        callGetRandomUser()

    }

    private fun callGetRandomUser() {
        mainViewModel.getRandomUser()
    }

    private fun initListener() {
        mainViewModel.randomUserLiveData.observe(this, {
            when (it) {
                is ServerResponse.Loading -> {
                    // if(mSwipeView.childCount <= 0) { // Enable to give continuous loading of new random user
                    showProgressBar()
                    // }
                }

                is ServerResponse.Success -> {
                    hideProgressBar()
                    //callGetRandomUser() // To give continuous loading of new Random user
                    mSwipeView.addView(TinderProfileCard(it.data.results[0].user, this, this))

                    Thread {
                        try {
                            Thread.sleep(1000) // Just to give smooth experience of swipe
                            mSwipeView.enableTouchSwipe()
                            //                    mSwipView.lockViews();
                            //                    Thread.currentThread().sleep(4000);
                            //                    mSwipView.unlockViews();
                            //                    Thread.currentThread().sleep(4000);
                            //                    mSwipView.lockViews();
                            //                    Thread.currentThread().sleep(4000);
                            //                    mSwipView.unlockViews();
                        } catch (e: InterruptedException) {
                            e.printStackTrace()
                        }
                    }.start()
                }

                is ServerResponse.Error -> {
                    hideProgressBar()
                    Toast.makeText(
                        applicationContext,
                        it.response.errorBody()?.string(),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        })
    }

    private fun showProgressBar() {
        progressBar.visibility = View.VISIBLE
        window?.setFlags(
            WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
            WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE
        )
    }

    private fun hideProgressBar() {
        progressBar.visibility = View.GONE
        window?.clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
    }

    override fun onAccepted(user: User) {
        mainViewModel.insertFavouritePeople(user)
        mainViewModel.getRandomUser()
    }

    override fun onRejected() {
        mainViewModel.getRandomUser()
    }
}