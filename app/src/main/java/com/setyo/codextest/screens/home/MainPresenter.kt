package com.setyo.codextest.screens.home

import android.util.Log
import com.google.gson.Gson
import com.setyo.codextest.data.network.models.NewsResponse
import com.setyo.codextest.data.network.service.ApiService
import com.setyo.codextest.data.network.service.Network
import com.setyo.codextest.data.network.service.retrofit.DataRepository
import com.setyo.codextest.utils.CoroutineContextProvider
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainPresenter(
    var MainView: MainView,
    var gson: Gson,
    var apiService: ApiService,
    var context: CoroutineContextProvider?
)  : MainPresenterImp{


    init {
        this.context = CoroutineContextProvider()
    }

    override fun getNewsData(newsId: String?) {

        MainView.showLoading()

        GlobalScope.launch(context?.main!!){
            val data = gson.fromJson(apiService
                .doRequest(Network.getNews(newsId)).await(),
                NewsResponse::class.java
            )
            MainView.setadapter(listOf(data))

            MainView.hideLoading()

        }

    }

    override fun getTopStories() {

        val apiInterface =  DataRepository.create()
        apiInterface.getTopStories().enqueue(object : Callback<List<String>> {

            override fun onResponse(call: Call<List<String>>, response: Response<List<String>>) {
                if (response.isSuccessful) {

                    val topStories: List<String>? = response.body()

                    MainView.success(topStories)

                }
            }

            override fun onFailure(call: Call<List<String>>, error: Throwable) {
                Log.e("tag", "error ${error.message}")
            }
        })

    }




}