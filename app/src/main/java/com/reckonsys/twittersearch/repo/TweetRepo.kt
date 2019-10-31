package com.reckonsys.twittersearch.repo

import androidx.lifecycle.MutableLiveData
import com.reckonsys.twittersearch.data.TweetSearch
import com.reckonsys.twittersearch.network.ApiClient
import com.reckonsys.twittersearch.util.Constants
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TweetRepo {

    val tweetSearchResult: MutableLiveData<TweetSearch> = MutableLiveData()
    val error: MutableLiveData<Boolean> = MutableLiveData()

    fun searchTweets(keyword: String, type: String) {
        val call = when (type) {
            Constants.FIRST -> ApiClient.getInstance().fetchTweet(keyword, 100)
            else -> {
                ApiClient.getInstance().fetchMore(
                    keyword = keyword.substringAfter("q=").substringBefore("&"),
                    maxId = keyword.substringAfter("max_id=").substringBefore("&").toLong(),
                    includeEntities = keyword.substringAfter("include_entities=").toInt(),
                    count = keyword.substringAfter("count=").substringBefore("&").toInt()
                )
            }
        }

        call.enqueue(object : Callback<TweetSearch> {
            override fun onFailure(call: Call<TweetSearch>, t: Throwable) {
                error.value = true
                t.printStackTrace()
            }

            override fun onResponse(call: Call<TweetSearch>, response: Response<TweetSearch>) {
                tweetSearchResult.value = response.body()
            }
        })
    }
}