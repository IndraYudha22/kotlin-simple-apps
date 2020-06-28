package com.strivere.githubuser.ui.mainmenu

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.strivere.githubuser.R
import com.strivere.githubuser.data.models.GithubUser
import com.strivere.githubuser.ui.RecyclerViewClickListener
import kotlinx.android.synthetic.main.main_menu_fragment.*
import org.json.JSONObject
import java.io.InputStream
import java.util.*


class MainMenuFragment : Fragment(), RecyclerViewClickListener {

    private var githubUsersList = arrayListOf<GithubUser>()


    companion object {
        fun newInstance() = MainMenuFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView =  inflater.inflate(R.layout.main_menu_fragment, container, false)

        return rootView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        loadJsonFile()
    }

    override fun onRecyclerViewItemClick(view: View, githubUser: GithubUser, id: String) {
        TODO("Not yet implemented")
    }

    fun loadJsonFile(){
        val inputStream : InputStream = resources.openRawResource(R.raw.githubuser)
        val jsonString: String = Scanner(inputStream).useDelimiter("\\A").next()

        try {
            val jsonObject = JSONObject(jsonString)
            val dataArr = jsonObject.getJSONArray("users")
            for (j in 0 until dataArr.length()) {
                val indexObj = dataArr.getJSONObject(j)
                val basicInfo = GithubUser(
                    username = indexObj.getString("username"),
                    name = indexObj.getString("name"),
                    avatar = indexObj.getString("avatar"),
                    company = indexObj.getString("company"),
                    location = indexObj.getString("location"),
                    repository = indexObj.getInt("repository"),
                    follower = indexObj.getInt("follower"),
                    following = indexObj.getInt("following")
                )

                githubUsersList.add(basicInfo)
            }
            rv_main_menu.also {
                it.layoutManager = LinearLayoutManager(requireContext())
                it.setHasFixedSize(true)
                it.adapter = MainMenuAdapter(githubUsersList, this)
            }

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

}
