package com.setyo.codextest.data.network.service

import com.setyo.codextest.BuildConfig

object Network {


    fun getNews(newsid: String?): String{
        return BuildConfig.BASE_URL + "v0/item/"+newsid+".json?print=pretty"
    }

    fun getComments(newsid: String?): String{
        return BuildConfig.BASE_URL + "v0/item/"+newsid+".json?print=pretty"
    }

}