package com.example.githubsearch

import android.content.Intent

import android.os.Bundle
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager

import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity(), SearchView.OnQueryTextListener {

    companion object{
        private val SECOND_ACTIVITY_DATA= "SECOND_ACTIVITY_DATA"
        fun getValSecAct(): String {
            return SECOND_ACTIVITY_DATA
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        search_view.setOnQueryTextListener(this)
    }
    private fun sendUserInfoToNextActivity(user: GitHubUser){


        val intent = Intent(this,UserInfoActivity::class.java)

        intent.putExtra(MainActivity.getValSecAct(),user)
        startActivity(intent)


    }
    override fun onQueryTextSubmit(query: String?): Boolean {

        if (query != null) {
            GitHubAPI.initRetrofit().Username(query).enqueue(
                object : Callback<GitHubResponse> {


                    override fun onResponse(call: Call<GitHubResponse>, response: Response<GitHubResponse>) {
                        if (response.isSuccessful) {

                            response.body()?.let {
                                
                                recycler_view.layoutManager =
                                    LinearLayoutManager(this@MainActivity)

                                recycler_view.adapter = UserAdapter(it,:: sendUserInfoToNextActivity)
                                //Log.d(TAG, "onResponse: ${it.size}")

                            }
                        }
                    }
                    override fun onFailure(call: Call<GitHubResponse>, t: Throwable) {
                        println("youfucked uuuuuppppp")
                    }

                }
            )
        }
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {

        return false
    }



}