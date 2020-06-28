package com.strivere.githubuser.ui

import android.view.View
import com.strivere.githubuser.data.GithubUser

interface RecyclerViewClickListener {
    fun onRecyclerViewItemClick(view: View, githubUser: GithubUser, username: String, name: String, avatar: String)
}