package com.strivere.githubuser.ui.mainmenu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.strivere.githubuser.R
import com.strivere.githubuser.data.GithubUser
import com.strivere.githubuser.ui.RecyclerViewClickListener
import com.strivere.githubuser.ui.detail.DetailFragment
import com.strivere.githubuser.utils.Initial
import kotlinx.android.synthetic.main.main_menu_fragment.*
import org.json.JSONObject
import java.io.InputStream
import java.util.*


class MainMenuFragment : Fragment(), RecyclerViewClickListener {

    private var githubUsersList = arrayListOf<GithubUser>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.main_menu_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        loadJsonFile()
    }

    private fun loadJsonFile(){
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


    fun showDetailFragment(githubUser: GithubUser){
        val bundle = Bundle()
        val detailFragment: Fragment = DetailFragment()
        val transaction = requireActivity().supportFragmentManager.beginTransaction()
        bundle.putParcelable(Initial.Users, githubUser)
        detailFragment.arguments = bundle
        transaction.replace(R.id.fragment, detailFragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    override fun onRecyclerViewItemClick(
        view: View,
        githubUser: GithubUser
    ) {
        showDetailFragment(githubUser)
    }

}
