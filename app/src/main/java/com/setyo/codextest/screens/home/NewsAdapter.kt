package com.setyo.codextest.screens.home

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.setyo.codextest.R
import com.setyo.codextest.data.network.models.NewsResponse
import kotlinx.android.synthetic.main.news_item.view.*
import org.jetbrains.anko.sdk27.coroutines.onClick

class NewsAdapter(private val news: List<NewsResponse>,
                  private val context: Context,
                  private val listener: (NewsResponse) -> Unit)
    : RecyclerView.Adapter<NewsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): NewsViewHolder {
        return NewsViewHolder((LayoutInflater.from(context).inflate(R.layout.news_item, parent, false)))
    }

    override fun getItemCount(): Int = news.size

    override fun onBindViewHolder(p0: NewsViewHolder, p1: Int) {
        p0.bindItem(news[p1], listener)
    }
}

class NewsViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    fun bindItem(newsResponse: NewsResponse, listener: (NewsResponse) -> Unit) {

        itemView.tv_score.text = newsResponse.score.toString()
        itemView.title.text = newsResponse.title

        itemView.onClick {
            listener(newsResponse)
        }


    }





}
