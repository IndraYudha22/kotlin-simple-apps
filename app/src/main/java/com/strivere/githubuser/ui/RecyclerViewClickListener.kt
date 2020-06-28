package com.strivere.githubuser.ui

import android.view.View
import com.strivere.githubuser.data.GithubUser

interface RecyclerViewClickListener {
    fun onRecyclerViewItemClick(view: View, githubUser: GithubUser, name: String, username: String, avatar: String, company: String, location: String, repository: Int, follower: Int, following: Int)
}