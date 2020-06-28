package com.strivere.githubuser.utils

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter

@BindingAdapter("image")
fun load(view: ImageView, url: String){
    val img : Int = view.resources.getIdentifier(url, null, view.context.packageName)
    val drawable: Drawable = view.resources.getDrawable(img)
    view.setImageDrawable(drawable)
}

