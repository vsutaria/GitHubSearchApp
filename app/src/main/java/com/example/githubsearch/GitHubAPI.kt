package com.example.githubsearch

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GitHubAPI {

    @GET("search/users")
    fun Username(@Query("q") userName : String): Call<GitHubResponse>

    @GET("/users/{user_name}")
    fun UserInfo(@Path("user_name") userName: String): Call<GitHubUser>

    companion object {
        fun initRetrofit(): GitHubAPI{
            return Retrofit.Builder().baseUrl("https://api.github.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(GitHubAPI::class.java)

        }
    }
}