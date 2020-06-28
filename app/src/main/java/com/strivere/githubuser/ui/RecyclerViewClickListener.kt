package com.strivere.githubuser.ui

import android.view.View
import com.strivere.githubuser.data.models.GithubUser

interface RecyclerViewClickListener {
    fun onRecyclerViewItemClick(view: View, githubUser: GithubUser, id: String)
}