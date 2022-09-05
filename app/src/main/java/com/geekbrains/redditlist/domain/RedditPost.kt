package com.geekbrains.redditlist.domain

data class RedditPost(
    val title: String,
    val score: Int,
    val comments: Int
)