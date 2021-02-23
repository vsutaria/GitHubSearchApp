package com.example.githubsearch

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class UserViewHolder(val view: View) : RecyclerView.ViewHolder(view){
    private val userImage: ImageView= view.findViewById(R.id.iv_user_image)
    private val userName: TextView= view.findViewById(R.id.tv_username)


    fun onBind(data: GitHubUser, activityTwo: (user: GitHubUser) -> Unit){
        view.setOnClickListener {
            activityTwo.invoke(data)
        }
        userName.text = data.login

        Picasso.get().load(data.avatar_url).into(userImage)

    }

}
