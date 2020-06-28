package com.strivere.githubuser.ui.mainmenu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson

import com.strivere.githubuser.R
import com.strivere.githubuser.data.models.GithubUser
import com.strivere.githubuser.data.repository.SafeJsonRequest
import com.strivere.githubuser.ui.RecyclerViewClickListener
import kotlinx.android.synthetic.main.main_menu_fragment.*

class MainMenuFragment : Fragment(), RecyclerViewClickListener {

    companion object {
        fun newInstance() = MainMenuFragment()
    }

    private lateinit var adapter: MainMenuAdapter
    private lateinit var dataUserName: Array<String>
    private lateinit var dataName: Array<String>
    private lateinit var dataLocation: Array<String>
    private lateinit var dataRepository: Array<String>
    private lateinit var dataCompany: Array<String>
    private lateinit var dataFollowers: Array<String>
    private lateinit var dataFollowing: Array<String>
    private lateinit var dataPhotos: Array<String>
    private var githubUsers = arrayListOf<GithubUser>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView =  inflater.inflate(R.layout.main_menu_fragment, container, false)

        return rootView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val user = Gson().fromJson(SafeJsonRequest().readJsonData(requireContext()), GithubUser::class.java)

        prepare()
        addItem()

        rv_main_menu.also {
            it.layoutManager = LinearLayoutManager(requireContext())
            it.setHasFixedSize(true)
            it.adapter = MainMenuAdapter(githubUsers, this)
        }
    }

    fun prepare(){
        dataUserName = requireActivity().resources.getStringArray(R.array.username)
        dataName = requireActivity().resources.getStringArray(R.array.name)
        dataLocation = requireActivity().resources.getStringArray(R.array.location)
        dataRepository = requireActivity().resources.getStringArray(R.array.repository)
        dataCompany = requireActivity().resources.getStringArray(R.array.company)
        dataFollowers = requireActivity().resources.getStringArray(R.array.followers)
        dataFollowing = requireActivity().resources.getStringArray(R.array.following)
        dataPhotos = requireActivity().resources.getStringArray(R.array.avatar)
    }

    fun addItem(){
        for (position in dataUserName.indices){
            val githubUser = GithubUser(
                dataUserName[position],
                dataName[position],
                dataLocation[position],
                dataRepository[position],
                dataCompany[position],
                dataFollowers[position],
                dataFollowing[position],
                dataPhotos[position]
            )
            githubUsers.add(githubUser)
        }
    }

    override fun onRecyclerViewItemClick(view: View, githubUser: GithubUser, id: String) {
        TODO("Not yet implemented")
    }

}
