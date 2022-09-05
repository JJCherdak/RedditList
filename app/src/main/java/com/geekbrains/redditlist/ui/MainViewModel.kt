package com.geekbrains.redditlist.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.geekbrains.redditlist.data.RemoteRepositoryImpl
import com.geekbrains.redditlist.data.Repository
import com.geekbrains.redditlist.domain.RedditPost
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import com.geekbrains.redditlist.data.network.Retrofit

class MainViewModel(private val repo: Repository = RemoteRepositoryImpl(Retrofit().getService())) :
    ViewModel() {

    private val liveDataToObserve: MutableLiveData<List<RedditPost>> = MutableLiveData(listOf())

    fun getData(): LiveData<List<RedditPost>> {
        return liveDataToObserve
    }

    fun requestPosts() = requestPostsFromApi()

    private fun requestPostsFromApi() {
        repo.getPosts()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                liveDataToObserve.postValue(it)
            }, {

            })
    }
}