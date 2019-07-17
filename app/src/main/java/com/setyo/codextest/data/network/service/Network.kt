package com.setyo.codextest.data.network.service

import com.setyo.codextest.BuildConfig

object Network {

//    var retrofit = Retrofit.Builder()
//
//
//        .baseUrl(BuildConfig.BASE_URL)
//        .addConverterFactory(GsonConverterFactory.create())
//        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//        .build()
//
//    var service = retrofit.create<ApiService>(ApiService::class.java!!)



    fun getNews(newsid: String?): String{
        return BuildConfig.BASE_URL + "v0/item/"+newsid+".json?print=pretty"
    }

    fun getTopStories(): String{
        return BuildConfig.BASE_URL + "v0/topstories.json?print=pretty"
    }


}