package com.strivere.githubuser.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.strivere.githubuser.R
import com.strivere.githubuser.data.GithubUser
import com.strivere.githubuser.databinding.FragmentDetailBinding
import com.strivere.githubuser.utils.Initial

class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding
    private lateinit var githubUser: GithubUser

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val bundle = this.arguments
        if (bundle != null){
            githubUser = bundle.getParcelable<GithubUser>(Initial.Users)!!
            binding.apply {
                binding.githubuser = githubUser
            }
        }

    }


}