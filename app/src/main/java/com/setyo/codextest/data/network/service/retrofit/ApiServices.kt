package com.setyo.codextest.data.network.service.retrofit

import retrofit2.Call
import retrofit2.http.GET

interface ApiServices {

    @GET("v0/topstories.json?print=pretty")
    fun getTopStories(): Call<List<String>>

}