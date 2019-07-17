package com.setyo.codextest.screens.detail

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.setyo.codextest.R
import com.setyo.codextest.data.network.models.CommentResponse
import com.setyo.codextest.screens.home.NewsViewHolder
import kotlinx.android.synthetic.main.comment_item.view.*

class DetailAdapter(
    private val listComment: List<CommentResponse>,
    private val context: Context
    ) : RecyclerView.Adapter<CommentViewHolder>() {


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): CommentViewHolder {
        return CommentViewHolder((LayoutInflater.from(context).inflate(R.layout.comment_item, p0, false)))

    }

    override fun getItemCount(): Int = listComment.size



    override fun onBindViewHolder(p0: CommentViewHolder, p1: Int) {
        p0.bindItem(listComment[p1])


    }
}

class CommentViewHolder (view: View) : RecyclerView.ViewHolder(view){

    fun bindItem(commentResponse: CommentResponse) {

        itemView.tv_name.text = commentResponse.by
        itemView.tv_teks.text = commentResponse.text

    }

}
