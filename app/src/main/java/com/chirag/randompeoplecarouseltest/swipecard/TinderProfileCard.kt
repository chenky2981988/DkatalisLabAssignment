package com.chirag.randompeoplecarouseltest.swipecard

import android.content.Context
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.chirag.randompeoplecarouseltest.R
import com.chirag.randompeoplecarouseltest.model.User
import com.chirag.randompeoplecarouseltest.utils.getDisplayAddress
import com.chirag.randompeoplecarouseltest.utils.getDisplayName
import com.mindorks.placeholderview.annotations.Click
import com.mindorks.placeholderview.annotations.Layout
import com.mindorks.placeholderview.annotations.NonReusable
import com.mindorks.placeholderview.annotations.Resolve
import com.mindorks.placeholderview.annotations.swipe.*


/**
 * Created by Chirag Sidhiwala on 6/9/20.
 */
@NonReusable
@Layout(R.layout.profile_card_view)
class TinderProfileCard(
    val user: User,
    private val swipeCardInterface: SwipeCardInterface,
    val context: Context
) {

    @com.mindorks.placeholderview.annotations.View(R.id.profile_imageview)
    lateinit var profileImageView: ImageView

    @com.mindorks.placeholderview.annotations.View(R.id.profile_title)
    lateinit var profileTitle: TextView

    @com.mindorks.placeholderview.annotations.View(R.id.profile_title_data)
    lateinit var profileData: TextView

    @com.mindorks.placeholderview.annotations.View(R.id.profile_name)
    lateinit var profileNameIv: ImageView

    @com.mindorks.placeholderview.annotations.View(R.id.profile_birthday)
    lateinit var profileBirthdayIv: ImageView

    @com.mindorks.placeholderview.annotations.View(R.id.profile_location)
    lateinit var profileLocationIv: ImageView

    @com.mindorks.placeholderview.annotations.View(R.id.profile_call)
    lateinit var profileCallIv: ImageView

    @com.mindorks.placeholderview.annotations.View(R.id.profile_email)
    lateinit var profileEmailIv: ImageView

    @com.mindorks.placeholderview.annotations.View(R.id.profile_password)
    lateinit var profilePasswardIv: ImageView

    @SwipeView
    lateinit var view: View

    @Resolve
    fun onResolved() {
        showProfileImage()
        showProfileName()
    }

    @SwipeOut
    fun onSwipedOut() {
        swipeCardInterface.onRejected()
    }

    @SwipeCancelState
    fun onSwipeCancelState() {
        Log.d("TAG", "onSwipeCancelState")
    }

    @SwipeIn
    fun onSwipeIn() {
        swipeCardInterface.onAccepted(user)
    }

    @SwipeInState
    fun onSwipeInState() {
        Log.d("TAG", "onSwipeInState")
    }

    @SwipeOutState
    fun onSwipeOutState() {
        Log.d("TAG", "onSwipeOutState")
    }

    @SwipeHead
    fun onSwipeHead() {
        Log.d("TAG", "onSwipeHead")
    }

    @Click(R.id.profile_name)
    fun onProfileNameClicked() {
        showProfileName()
    }

    @Click(R.id.profile_birthday)
    fun onProfileBirthdayClicked() {
        showProfileDOB()
    }

    @Click(R.id.profile_location)
    fun onProfileLocationClicked() {
        showProfileLocation()
    }

    @Click(R.id.profile_call)
    fun onProfileCallClicked() {
        showProfilePhoneNumber()
    }

    @Click(R.id.profile_email)
    fun onProfileEmailClicked() {
        showProfileEmail()
    }

    @Click(R.id.profile_password)
    fun onProfilePasswordClicked() {
        showProfilePassword()
    }

    private fun showProfileImage() {
        user.let {
            Glide.with(context)
                .load(it.picture)
                .centerCrop()
                .placeholder(R.drawable.ic_profile_user)
                .into(profileImageView)
        }
    }

    private fun showProfileName() {
        user.let {
            profileTitle.text = context.getString(R.string.name_header)
            profileData.text = getDisplayName(it.name)
        }
    }

    private fun showProfileDOB() {
        user.let {
            profileTitle.text = context.getString(R.string.birthday_header)
            profileData.text = it.dob
        }
    }

    private fun showProfileLocation() {
        user.let {
            profileTitle.text = context.getString(R.string.address_header)
            profileData.text = getDisplayAddress(it.location)
        }
    }

    private fun showProfilePhoneNumber() {
        user.let {
            profileTitle.text = context.getString(R.string.phone_header)
            profileData.text = it.cell
        }
    }

    private fun showProfileEmail() {
        user.let {
            profileTitle.text = context.getString(R.string.email_header)
            profileData.text = it.email
        }
    }

    private fun showProfilePassword() {
        user.let {
            profileTitle.text = context.getString(R.string.password_header)
            profileData.text = it.password
        }
    }

}