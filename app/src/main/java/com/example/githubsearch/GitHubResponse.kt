package com.example.githubsearch

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/*{



  "gists_url": "https://api.github.com/users/VishrutMehta/gists{/gist_id}",
  "starred_url": "https://api.github.com/users/VishrutMehta/starred{/owner}{/repo}",
  "subscriptions_url": "https://api.github.com/users/VishrutMehta/subscriptions",
  "organizations_url": "https://api.github.com/users/VishrutMehta/orgs",
  "repos_url": "https://api.github.com/users/VishrutMehta/repos",
  "events_url": "https://api.github.com/users/VishrutMehta/events{/privacy}",
  "received_events_url": "https://api.github.com/users/VishrutMehta/received_events",
  "type": "User",
  "site_admin": false,
  "name": "Vishrut Mehta",
  "company": null,
  "blog": "http://web.iiit.ac.in/~vishrut.mehta/",
  "location": "Hyderabad, Andhra Pradesh",
  "email": null,
  "hireable": true,
  "bio": null,
  "twitter_username": null,
  "public_repos": 29,
  "public_gists": 1,
  "followers": 48,
  "following": 59,
  "created_at": "2012-05-21T18:36:11Z",
  "updated_at": "2020-10-07T19:00:55Z"
}*/


@Parcelize
data class GitHubResponse(
    val total_count: Int,
    val items: List<GitHubUser>


):Parcelable

@Parcelize
data class GitHubUser(val login: String,
                      val avatar_url: String,
                      val url: String,
                      val email: String?,
                      val location: String?,
                      val created_at: String?,
                      val followers: Int?,
                      val following: Int?,
                      val bio: String?
                      //var allInfo: GitHubUserInfo
):Parcelable


//@Parcelize
//data class GitHubUserInfo(


//):Parcelable