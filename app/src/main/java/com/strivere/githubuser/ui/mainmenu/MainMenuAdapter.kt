package com.strivere.githubuser.ui.mainmenu

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.strivere.githubuser.R
import com.strivere.githubuser.data.GithubUser
import com.strivere.githubuser.databinding.RecyclerviewMainMenuBinding
import com.strivere.githubuser.ui.RecyclerViewClickListener
import kotlinx.android.extensions.LayoutContainer

class MainMenuAdapter (private val githubuser : List<GithubUser>, private val listener: RecyclerViewClickListener)
    : RecyclerView.Adapter<MainMenuAdapter.MainMenuViewHolder>(){

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
        holder.recyclerviewMenuBinding.layoutRv.setOnClickListener {
            listener.onRecyclerViewItemClick(holder.recyclerviewMenuBinding.layoutRv, githubuser[position],
                githubuser[holder.adapterPosition].name,
                githubuser[holder.adapterPosition].username,
                githubuser[holder.adapterPosition].avatar,
                githubuser[holder.adapterPosition].company,
                githubuser[holder.adapterPosition].location,
                githubuser[holder.adapterPosition].repository,
                githubuser[holder.adapterPosition].follower,
                githubuser[holder.adapterPosition].following)
        }
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