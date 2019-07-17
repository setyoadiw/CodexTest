package com.setyo.codextest.screens.detail

import android.util.Log
import com.google.gson.Gson
import com.setyo.codextest.data.network.models.CommentResponse
import com.setyo.codextest.data.network.models.NewsResponse
import com.setyo.codextest.data.network.service.ApiService
import com.setyo.codextest.data.network.service.Network
import com.setyo.codextest.utils.CoroutineContextProvider
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class DetailPresenter(
    var DetailView: DetailView,
    var gson: Gson,
    var apiService: ApiService,
    var context: CoroutineContextProvider?
) : DetailPresenterImp {


    override fun getComment(newsId: String?) {

        GlobalScope.launch(context?.main!!){
            val data = gson.fromJson(apiService
                .doRequest(Network.getComments(newsId)).await(),
                CommentResponse::class.java
            )

            DetailView.setcommentadapter(listOf(data))

            Log.d("tagres", data.toString())


        }

    }
}