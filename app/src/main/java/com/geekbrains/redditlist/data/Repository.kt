package com.geekbrains.redditlist.data

import com.geekbrains.redditlist.domain.RedditPost
import io.reactivex.rxjava3.core.Single

interface Repository {

    fun getPosts(): Single<List<RedditPost>>
}