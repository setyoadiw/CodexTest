package com.setyo.codextest.screens.detail

import com.setyo.codextest.data.network.models.CommentResponse

interface DetailView {

    fun setcommentadapter(data: List<CommentResponse>)

}