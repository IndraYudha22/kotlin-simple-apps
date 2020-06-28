package com.strivere.githubuser.ui.mainmenu

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.strivere.githubuser.R
import com.strivere.githubuser.data.models.GithubUser
import com.strivere.githubuser.databinding.RecyclerviewMainMenuBinding
import com.strivere.githubuser.ui.RecyclerViewClickListener
import kotlinx.android.extensions.LayoutContainer
import java.util.*

class MainMenuAdapter (private val githubuser : List<GithubUser>, private val listener: RecyclerViewClickListener)
    : RecyclerView.Adapter<MainMenuAdapter.MainMenuViewHolder>(){

    val context: Context? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        MainMenuViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.recyclerview_main_menu,
                parent,
                false
            )
        )

    override fun getItemCount(): Int {
        return githubuser.size
    }

    override fun onBindViewHolder(holder: MainMenuViewHolder, position: Int) {
        holder.recyclerviewMenuBinding.githubuser = githubuser[position]
        holder.bindItem(githubuser[position])

    }

    inner class MainMenuViewHolder(
        val recyclerviewMenuBinding: RecyclerviewMainMenuBinding
    ) : RecyclerView.ViewHolder(recyclerviewMenuBinding.root), LayoutContainer {
        override val containerView: View?
            get() = itemView

        fun bindItem(item: GithubUser){
            containerView?.context.let {
                recyclerviewMenuBinding.githubuser = item
                recyclerviewMenuBinding.executePendingBindings()
            }
        }

    }
}