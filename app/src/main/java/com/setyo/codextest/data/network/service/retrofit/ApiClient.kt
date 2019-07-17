package com.setyo.codextest.data.network.service.retrofit

import com.setyo.codextest.BuildConfig
import javax.xml.datatype.DatatypeConstants.SECONDS
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit
import okhttp3.OkHttpClient


object DataRepository {

        fun create(): ApiServices {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BuildConfig.BASE_URL)
                .build()
            return retrofit.create(ApiServices::class.java)
        }
    }
