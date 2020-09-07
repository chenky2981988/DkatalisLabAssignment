package com.chirag.randompeoplecarouseltest.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.chirag.randompeoplecarouseltest.R
import com.chirag.randompeoplecarouseltest.model.User
import com.chirag.randompeoplecarouseltest.swipecard.SwipeCardInterface
import com.chirag.randompeoplecarouseltest.swipecard.TinderProfileCard
import com.mindorks.butterknifelite.ButterKnifeLite
import com.mindorks.butterknifelite.annotations.BindView
import com.mindorks.placeholderview.SwipeDecor
import com.mindorks.placeholderview.SwipePlaceHolderView
import com.mindorks.placeholderview.SwipeViewBuilder

class ProfileViewActivity : AppCompatActivity(), SwipeCardInterface {

    @BindView(R.id.swipeView)
    lateinit var mSwipView: SwipePlaceHolderView

    private lateinit var user: User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_view)
        ButterKnifeLite.bind(this)
        user = intent.getParcelableExtra<User>("user")!!
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        loadDataOnUi()
    }

    private fun loadDataOnUi() {
        mSwipView.getBuilder<SwipePlaceHolderView, SwipeViewBuilder<SwipePlaceHolderView>>() //                .setSwipeType(SwipePlaceHolderView.SWIPE_TYPE_VERTICAL)
            .setDisplayViewCount(3)
            .setIsUndoEnabled(true)
            .setWidthSwipeDistFactor(4f)
            .setHeightSwipeDistFactor(6f)
            .setSwipeDecor(
                SwipeDecor() //                        .setMarginTop(300)
                    //                        .setMarginLeft(100)
                    //                        .setViewGravity(Gravity.TOP)
                    .setPaddingTop(20)
                    .setSwipeMaxChangeAngle(2f)
                    .setRelativeScale(0.01f)
            )
        mSwipView.disableTouchSwipe()
        mSwipView.addView(TinderProfileCard(user, this, this))

    }

    override fun onAccepted(user: User) {
        TODO("Not yet implemented")
    }

    override fun onRejected() {
        TODO("Not yet implemented")
    }

}