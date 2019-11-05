package com.abc.twittersearch.network

import com.abc.twittersearch.util.Constants
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import se.akerfeldt.okhttp.signpost.OkHttpOAuthConsumer
import se.akerfeldt.okhttp.signpost.SigningInterceptor


class ApiClient {
    companion object {

        fun getInstance(): TweetApi {
            val consumer =
                OkHttpOAuthConsumer(Constants.Api.CONSUMER_KEY, Constants.Api.CONSUMER_SECRET)
            consumer.setTokenWithSecret(Constants.Api.ACCESS_TOKEN, Constants.Api.ACCESS_SECRET)

            val client = OkHttpClient.Builder()
                .addInterceptor(SigningInterceptor(consumer))
                .build()

            val retrofit = Retrofit.Builder()
                .baseUrl(Constants.Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()

            return retrofit.create(TweetApi::class.java)
        }
    }
}