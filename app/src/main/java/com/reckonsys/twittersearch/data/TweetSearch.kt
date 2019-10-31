package com.reckonsys.twittersearch.data

import com.google.gson.annotations.SerializedName

data class TweetSearch(
    @SerializedName("search_metadata")
    val searchMetadata: SearchMetadata? = null,
    val statuses: List<Statuses>? = null
) {
    data class SearchMetadata(
        val count: Int? = null,
        val max_id: Long? = null,
        val max_id_str: String? = null,
        val next_results: String? = null,
        val query: String? = null,
        val refresh_url: String? = null,
        val since_id: Int? = null,
        val since_id_str: String? = null
    )

    data class Statuses(
        val entities: Entities? = null,
        val extended_entities: ExtendedEntities? = null,
        val favorite_count: Int? = null,
        val favorited: Boolean? = null,
        val id: Long? = null,
        val metadata: Metadata? = null,
        val possibly_sensitive: Boolean? = null,
        val retweet_count: Int? = null,
        val retweeted_status: RetweetedStatus? = null,
        val source: String? = null,
        val text: String? = null,
        val user: User? = null
    ) {
        data class Entities(
            val hashtags: List<Any?>? = null,
            val symbols: List<Any?>? = null,
            val urls: List<Any?>? = null,
            val user_mentions: List<UserMention?>? = null
        ) {
            data class UserMention(
                val id: Long? = null,
                val id_str: String? = null,
                val indices: List<Int?>? = null,
                val name: String? = null,
                val screen_name: String? = null
            )
        }

        data class ExtendedEntities(
            val media: List<Media?>? = null
        ) {
            data class Media(
                val display_url: String? = null,
                val expanded_url: String? = null,
                val id: Long? = null,
                val id_str: String? = null,
                val indices: List<Int?>? = null,
                val media_url: String? = null,
                val media_url_https: String? = null,
                val sizes: Sizes? = null,
                val source_status_id: Long? = null,
                val source_status_id_str: String? = null,
                val source_user_id: Long? = null,
                val source_user_id_str: String? = null,
                val type: String? = null,
                val url: String? = null
            ) {
                data class Sizes(
                    val large: Large? = null,
                    val medium: Medium? = null,
                    val small: Small? = null,
                    val thumb: Thumb? = null
                ) {
                    data class Large(
                        val h: Int? = null,
                        val resize: String? = null,
                        val w: Int? = null
                    )

                    data class Medium(
                        val h: Int? = null,
                        val resize: String? = null,
                        val w: Int? = null
                    )

                    data class Small(
                        val h: Int? = null,
                        val resize: String? = null,
                        val w: Int? = null
                    )

                    data class Thumb(
                        val h: Int? = null,
                        val resize: String? = null,
                        val w: Int? = null
                    )
                }
            }
        }

        data class Metadata(
            val iso_language_code: String? = null,
            val result_type: String? = null
        )

        data class Place(
            val attributes: Attributes? = null,
            val bounding_box: BoundingBox? = null,
            val contained_within: List<Any?>? = null,
            val country: String? = null,
            val country_code: String? = null,
            val full_name: String? = null,
            val id: String? = null,
            val name: String? = null,
            val place_type: String? = null,
            val url: String? = null
        ) {
            class Attributes

            data class BoundingBox(
                val coordinates: List<List<Any?>?>? = null,
                val type: String? = null
            )
        }

        data class RetweetedStatus(
            val contributors: Any? = null,
            val coordinates: Any? = null,
            val created_at: String? = null,
            val entities: Entities? = null,
            val favorite_count: Int? = null,
            val favorited: Boolean? = null,
            val geo: Any? = null,
            val id: Long? = null,
            val id_str: String? = null,
            val in_reply_to_screen_name: Any? = null,
            val in_reply_to_status_id: Any? = null,
            val in_reply_to_status_id_str: Any? = null,
            val in_reply_to_user_id: Any? = null,
            val in_reply_to_user_id_str: Any? = null,
            val is_quote_status: Boolean? = null,
            val lang: String? = null,
            val metadata: Metadata? = null,
            val place: Any? = null,
            val possibly_sensitive: Boolean? = null,
            val retweet_count: Int? = null,
            val retweeted: Boolean? = null,
            val source: String? = null,
            val text: String? = null,
            val truncated: Boolean? = null,
            val user: User? = null
        ) {
            data class Entities(
                val hashtags: List<Any?>? = null,
                val symbols: List<Any?>? = null,
                val urls: List<Url?>? = null,
                val user_mentions: List<Any?>? = null
            ) {
                data class Url(
                    val display_url: String? = null,
                    val expanded_url: String? = null,
                    val indices: List<Int?>? = null,
                    val url: String? = null
                )
            }

            data class Metadata(
                val iso_language_code: String? = null,
                val result_type: String? = null
            )

            data class User(
                val contributors_enabled: Boolean? = null,
                val created_at: String? = null,
                val default_profile: Boolean? = null,
                val default_profile_image: Boolean? = null,
                val description: String? = null,
                val entities: Entities? = null,
                val favourites_count: Int? = null,
                val follow_request_sent: Boolean? = null,
                val followers_count: Int? = null,
                val following: Boolean? = null,
                val friends_count: Int? = null,
                val geo_enabled: Boolean? = null,
                val has_extended_profile: Boolean? = null,
                val id: Long? = null,
                val id_str: String? = null,
                val is_translation_enabled: Boolean? = null,
                val is_translator: Boolean? = null,
                val lang: Any? = null,
                val listed_count: Int? = null,
                val location: String? = null,
                val name: String? = null,
                val notifications: Boolean? = null,
                val profile_background_color: String? = null,
                val profile_background_image_url: String? = null,
                val profile_background_image_url_https: String? = null,
                val profile_background_tile: Boolean? = null,
                val profile_banner_url: String? = null,
                val profile_image_url: String? = null,
                val profile_image_url_https: String? = null,
                val profile_link_color: String? = null,
                val profile_sidebar_border_color: String? = null,
                val profile_sidebar_fill_color: String? = null,
                val profile_text_color: String? = null,
                val profile_use_background_image: Boolean? = null,
                val `protected`: Boolean? = null,
                val screen_name: String? = null,
                val statuses_count: Int? = null,
                val time_zone: Any? = null,
                val translator_type: String? = null,
                val url: String? = null,
                val utc_offset: Any? = null,
                val verified: Boolean? = null
            ) {
                data class Entities(
                    val description: Description? = null,
                    val url: Url? = null
                ) {
                    data class Description(
                        val urls: List<Any?>? = null
                    )

                    data class Url(
                        val urls: List<Url?>? = null
                    ) {
                        data class Url(
                            val display_url: String? = null,
                            val expanded_url: String? = null,
                            val indices: List<Int?>? = null,
                            val url: String? = null
                        )
                    }
                }
            }
        }

        data class User(
            val contributors_enabled: Boolean? = null,
            val created_at: String? = null,
            val default_profile: Boolean? = null,
            val default_profile_image: Boolean? = null,
            val description: String? = null,
            val entities: Entities? = null,
            val favourites_count: Int? = null,
            val follow_request_sent: Boolean? = null,
            val followers_count: Int? = null,
            val following: Boolean? = null,
            val friends_count: Int? = null,
            val geo_enabled: Boolean? = null,
            val has_extended_profile: Boolean? = null,
            val id: Long? = null,
            val id_str: String? = null,
            val is_translation_enabled: Boolean? = null,
            val is_translator: Boolean? = null,
            val lang: Any? = null,
            val listed_count: Int? = null,
            val location: String? = null,
            val name: String? = null,
            val notifications: Boolean? = null,
            val profile_background_color: String? = null,
            val profile_background_image_url: String? = null,
            val profile_background_image_url_https: String? = null,
            val profile_background_tile: Boolean? = null,
            val profile_banner_url: String? = null,
            val profile_image_url: String? = null,
            val profile_image_url_https: String? = null,
            val profile_link_color: String? = null,
            val profile_sidebar_border_color: String? = null,
            val profile_sidebar_fill_color: String? = null,
            val profile_text_color: String? = null,
            val profile_use_background_image: Boolean? = null,
            val `protected`: Boolean? = null,
            val screen_name: String? = null,
            val statuses_count: Int? = null,
            val time_zone: Any? = null,
            val translator_type: String? = null,
            val url: Any? = null,
            val utc_offset: Any? = null,
            val verified: Boolean? = null
        ) {
            data class Entities(
                val description: Description? = null
            ) {
                data class Description(
                    val urls: List<Any?>? = null
                )
            }
        }
    }
}