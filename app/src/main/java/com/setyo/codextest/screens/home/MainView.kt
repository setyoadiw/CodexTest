package com.setyo.codextest.screens.home

import com.setyo.codextest.data.network.models.NewsResponse

interface MainView {

    fun success(data: List<String>?)
    fun failed(pesan : String)
    fun setadapter(data: List<NewsResponse>)
    fun showLoading()
    fun hideLoading()

}