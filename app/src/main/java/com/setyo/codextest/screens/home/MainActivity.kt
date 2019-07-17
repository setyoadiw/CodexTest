package com.setyo.codextest.screens.home

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.widget.ProgressBar
import android.widget.Toast
import com.google.gson.Gson
import com.setyo.codextest.R
import com.setyo.codextest.data.network.models.News
import com.setyo.codextest.data.network.models.NewsResponse
import com.setyo.codextest.data.network.service.ApiService
import com.setyo.codextest.screens.detail.DetailActivity
import com.setyo.codextest.utils.CoroutineContextProvider
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import org.jetbrains.anko.find


class MainActivity : AppCompatActivity() ,MainView {



    lateinit var presenter : MainPresenter
    val api = ApiService()
    val gson = Gson()
    var context: CoroutineContextProvider? = CoroutineContextProvider()


//    var list: List<NewsResponse> = null
    private var listData: MutableList<NewsResponse> = mutableListOf()

    private lateinit var newsAdapter: NewsAdapter
    private lateinit var listNews: RecyclerView
    private lateinit var progressBar: ProgressBar

    override fun failed(pesan: String) {

    }

    override fun showLoading() {

    }

    override fun hideLoading() {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        initPresenter()
        initView()

    }

    private fun initPresenter() {

        presenter = MainPresenter(this,gson,api,context)


    }

    private fun initView() {

        progressBar = find(R.id.progressbar)

        presenter.getTopStories()



    }


    override fun setadapter(data: List<NewsResponse>) {

        newsAdapter = NewsAdapter(listData,this, { partItem: NewsResponse -> partItemClicked(partItem) })

        listData.addAll(data)

        recyclerview_news.adapter = newsAdapter

        recyclerview_news.layoutManager = LinearLayoutManager(this)

        newsAdapter.notifyDataSetChanged()


    }

    override fun success(data: List<String>?) {

        for (i in 1..8) {
            presenter.getNewsData(data?.get(i))
        }



    }

    private fun partItemClicked(partItem: NewsResponse) {

        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("dataParcel",partItem)
        startActivity(intent)

    }



}
