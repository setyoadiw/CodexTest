package com.setyo.codextest.screens.detail

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.setyo.codextest.R
import com.setyo.codextest.data.network.models.NewsResponse
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        initView()
    }

    private fun initView() {

        val dataParcel = intent.extras.getParcelable<NewsResponse>("dataParcel")

        tv_judul.text = dataParcel.title
        tv_pengarang.text = "By "+ dataParcel.by


    }
}
