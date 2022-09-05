package com.geekbrains.redditlist.data.network

import com.geekbrains.redditlist.domain.ApiResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("top.json?limit=10")
    fun getPosts(@Query("after") after: String): Single<ApiResponse>
}