package com.strivere.githubuser.data.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GithubUser(
    val avatar: String,
    val company: String,
    val follower: Int,
    val following: Int,
    val location: String,
    val name: String,
    val repository: Int,
    val username: String
) : Parcelable

