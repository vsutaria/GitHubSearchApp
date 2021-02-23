package com.example.githubsearch

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_user_info.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserInfoActivity : AppCompatActivity() {
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_info)
        val intent= getIntent()//getIntent(SECOND_ACTIVITY_DATA)

        var user= intent.getParcelableExtra<GitHubUser>(MainActivity.getValSecAct())


        if (user != null) {

            val query = user.login
            GitHubAPI.initRetrofit().UserInfo(query).enqueue(
                    object : Callback<GitHubUser> {


                        override fun onResponse(call: Call<GitHubUser>, response: Response<GitHubUser>) {
                            if (response.isSuccessful) {

                                response.body()?.let {
                                    user = it

                                    tv_username.text = user?.login
                                    tv_email.text= user?.email
                                    tv_location.text = user?.location
                                    tv_join_date.text = user?.created_at
                                    tv_followers.text = user?.followers.toString()
                                    tv_following.text = user?.following.toString()
                                    tv_bio.text = user?.bio
                                    Picasso.get().load(user?.avatar_url).into(iv_user_image)
                                }
                            }
                        }


                        override fun onFailure(call: Call<GitHubUser>, t: Throwable) {
                            println("youfucked uuuuuppppp")
                        }

                    }
            )





        }

    }


}