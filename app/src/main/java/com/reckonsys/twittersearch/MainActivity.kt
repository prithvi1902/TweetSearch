package com.reckonsys.twittersearch

import android.os.Bundle
import android.text.TextUtils
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.reckonsys.twittersearch.data.TweetSearch
import com.reckonsys.twittersearch.util.Constants
import com.reckonsys.twittersearch.util.ViewUtil
import com.reckonsys.twittersearch.view.TweetAdapter
import com.reckonsys.twittersearch.viewmodel.TwitterViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val tweetsList = ArrayList<TweetSearch.Statuses?>()
        var nextResult = ""
        var isLoading = false
        val tweetsAdapter = TweetAdapter(tweetsList)

        rvTweets.apply {
            adapter = tweetsAdapter
            layoutManager =
                LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
        }

        val twitterViewModel = ViewModelProviders.of(this).get(TwitterViewModel::class.java)
        twitterViewModel.apply {
            searchList.observe(this@MainActivity, Observer { result ->
                result?.statuses?.let {
                    tweetsList.apply {
                        if (isLoading) {
                            tweetsList.removeAt(tweetsList.size - 1)
                            tweetsAdapter.notifyItemRemoved(tweetsList.size)
                            addAll(it)
                            isLoading = false
                        } else {
                            clear()
                            addAll(it)
                        }
                    }
                    tweetsAdapter.notifyDataSetChanged()
                    actvNoTweets.visibility = View.GONE
                    nextResult = result.searchMetadata?.next_results ?: ""
                } ?: run {
                    if (isLoading) {
                        tweetsList.removeAt(tweetsList.size - 1)
                        tweetsAdapter.notifyItemRemoved(tweetsList.size)
                        isLoading = false
                        tweetsAdapter.notifyDataSetChanged()
                        Snackbar.make(
                            rvTweets,
                            getString(R.string.no_more_tweets),
                            Snackbar.LENGTH_SHORT
                        ).show()
                    } else {
                        actvNoTweets.apply {
                            visibility = View.VISIBLE
                            text = getString(R.string.oops_something_went_wrong)
                        }
                    }
                }
            })
            error.observe(this@MainActivity, Observer {
                if (it == true) {
                    actvNoTweets.apply {
                        visibility = View.VISIBLE
                        text = getString(R.string.oops_something_went_wrong)
                    }
                }
            })
        }

        ibSearch.setOnClickListener {
            if (TextUtils.isEmpty(actvSearch.text)) {
                Snackbar.make(it, getString(R.string.error_no_keyword), Snackbar.LENGTH_LONG).show()
                it?.requestFocus()
            } else {
                ViewUtil.hideKeyboard(this)
                twitterViewModel.fetchTweets(actvSearch.text.trim().toString(), Constants.FIRST)
            }
        }

        rvTweets.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                val linearLayoutManager = recyclerView.layoutManager as LinearLayoutManager?

                if (!isLoading && linearLayoutManager != null && linearLayoutManager.findLastCompletelyVisibleItemPosition() == tweetsList.size - 1
                    && !TextUtils.isEmpty(nextResult)
                ) {
                    tweetsList.add(null)
                    tweetsAdapter.notifyItemInserted(tweetsList.size - 1)
                    twitterViewModel.fetchTweets(nextResult, Constants.MORE)
                    isLoading = true
                }
            }
        })
    }
}
