package com.setyo.codextest.screens.detail

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.google.gson.Gson
import com.setyo.codextest.R
import com.setyo.codextest.data.network.models.CommentResponse
import com.setyo.codextest.data.network.models.NewsResponse
import com.setyo.codextest.data.network.service.ApiService
import com.setyo.codextest.utils.CoroutineContextProvider
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() , DetailView{

    lateinit var presenter : DetailPresenter

    val api = ApiService()
    val gson = Gson()
    var context: CoroutineContextProvider? = CoroutineContextProvider()

    private var listComment: MutableList<CommentResponse> = mutableListOf()
    private lateinit var commentAdapter: DetailAdapter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        initPresenter()
        initView()
    }

    private fun initPresenter() {

        presenter = DetailPresenter(this,gson,api,context)

    }

    private fun initView() {

        val dataParcel = intent.extras.getParcelable<NewsResponse>("dataParcel")

        tv_judul.text = dataParcel.title
        tv_pengarang.text = "By "+ dataParcel.by

        for (i in 0..dataParcel.kids!!.size-1) {
            presenter.getComment(dataParcel.kids[i].toString())
        }



    }

    override fun setcommentadapter(data: List<CommentResponse>) {

        commentAdapter = DetailAdapter(listComment,this)

        listComment.addAll(data)

        recyclerview_comment.adapter = commentAdapter

        recyclerview_comment.layoutManager = LinearLayoutManager(this)

        commentAdapter.notifyDataSetChanged()




    }
}
