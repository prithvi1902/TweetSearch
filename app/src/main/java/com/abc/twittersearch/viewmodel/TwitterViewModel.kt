package com.abc.twittersearch.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.abc.twittersearch.data.TweetSearch
import com.abc.twittersearch.repo.TweetRepo

class TwitterViewModel : ViewModel() {

    private val tweetRepo = TweetRepo()
    var searchList: LiveData<TweetSearch> = MutableLiveData()
    var error: LiveData<Boolean> = MutableLiveData()

    init {
        searchList = tweetRepo.tweetSearchResult
        error = tweetRepo.error
    }

    fun fetchTweets(keyword: String, type: String) {
        tweetRepo.searchTweets(keyword, type)
    }
}