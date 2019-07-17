package com.setyo.codextest.data.network.models

import com.google.gson.annotations.SerializedName

data class News(

    @field:SerializedName("score")
    val score: String? = null,

    @field:SerializedName("title")
    val title: String? = null,

    @field:SerializedName("comment")
    val comment: String? = null
)