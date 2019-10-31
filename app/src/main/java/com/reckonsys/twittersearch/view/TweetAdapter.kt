package com.reckonsys.twittersearch.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.reckonsys.twittersearch.R
import com.reckonsys.twittersearch.data.TweetSearch
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_tweet_data.view.*

class TweetAdapter(private val tweetsList: ArrayList<TweetSearch.Statuses?>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val VIEW_TYPE_ITEM = 0
        private const val VIEW_TYPE_LOADING = 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            VIEW_TYPE_ITEM -> {
                TweetViewHolder(
                    LayoutInflater.from(parent.context).inflate(
                        R.layout.item_tweet_data,
                        parent,
                        false
                    )
                )
            }
            else -> {
                LoadingViewHolder(
                    LayoutInflater.from(parent.context).inflate(
                        R.layout.item_loading,
                        parent,
                        false
                    )
                )
            }
        }
    }

    override fun getItemCount(): Int {
        return tweetsList.size
    }

    override fun getItemViewType(position: Int): Int {
        return if (tweetsList[position] == null) {
            VIEW_TYPE_LOADING
        } else {
            VIEW_TYPE_ITEM
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is TweetViewHolder -> {
                holder.setData(tweetsList[position])
            }
        }
    }

    class TweetViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        fun setData(statuses: TweetSearch.Statuses?) {
            view.apply {
                Picasso
                    .get()
                    .load(statuses?.user?.profile_image_url_https)
                    .placeholder(R.drawable.ic_image_placeholder_grey_24dp)
                    .into(acivProfileImage)
                acivFavouriteIcon.setImageResource(
                    if (statuses?.favorited == true) {
                        R.drawable.ic_favorite_red_24dp
                    } else {
                        R.drawable.ic_favorite_border_black_24dp
                    }
                )
                actvFavouriteCount.text = statuses?.favorite_count.toString()
                actvTweetText.text = statuses?.text
            }
        }
    }

    class LoadingViewHolder(view: View) : RecyclerView.ViewHolder(view)
}