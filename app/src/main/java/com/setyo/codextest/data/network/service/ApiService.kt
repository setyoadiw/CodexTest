package com.setyo.codextest.data.network.service

import com.setyo.codextest.data.network.models.NewsResponse
import io.reactivex.Observable
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import java.net.URL

class ApiService {




//    @GET("v0/topstories.json?print=pretty")
//    fun getTopStories(): Observable<List<Int>>
//
//    @GET("v0/item/{articleid}.json?print=pretty")
//    fun getArticle(@Path("articleid") id: String?): Observable<NewsResponse>


    fun doRequest(url: String): Deferred<String> = GlobalScope.async {
        URL(url).readText()
    }



}