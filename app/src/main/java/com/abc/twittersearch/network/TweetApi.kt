package com.abc.twittersearch.network

import com.abc.twittersearch.data.TweetSearch
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface TweetApi {

    @GET("1.1/search/tweets.json")
    fun fetchTweet(
        @Query("q") keyword: String,
        @Query("count") count: Int
    ): Call<TweetSearch>

    @GET("1.1/search/tweets.json")
    fun fetchMore(
        @Query("q") keyword: String,
        @Query("max_id") maxId: Long,
        @Query("include_entities") includeEntities: Int,
        @Query("count") count: Int
    ): Call<TweetSearch>
}
