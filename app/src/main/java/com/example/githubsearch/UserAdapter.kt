package com.example.githubsearch

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class UserAdapter(val dataSet: GitHubResponse, val activityTwo:(user: GitHubUser)->Unit): RecyclerView.Adapter<UserViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(
            LayoutInflater.from(parent.context).inflate(
            R.layout.fragment_display_users,parent,false
        ))
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.onBind(dataSet.items[position], activityTwo)
    }

    override fun getItemCount(): Int {
        return dataSet.total_count
    }
}