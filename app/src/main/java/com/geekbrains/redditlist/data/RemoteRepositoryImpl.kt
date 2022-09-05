package com.geekbrains.redditlist.data

import com.geekbrains.redditlist.data.network.ApiService
import com.geekbrains.redditlist.domain.RedditPost
import com.geekbrains.redditlist.domain.convertResponseToPosts
import io.reactivex.rxjava3.core.Single

class RemoteRepositoryImpl (private val repo: ApiService) : Repository {
    var after: String = ""

    override fun getPosts(): Single<List<RedditPost>> {
        return repo.getPosts(after).map {
            this.after = it.data.after
            convertResponseToPosts(it)
        }
    }
}