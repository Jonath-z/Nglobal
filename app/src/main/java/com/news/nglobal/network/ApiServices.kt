package com.news.nglobal.network

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

class ApiServices {
    private val apiUrl = "https://newsdata.io/api/1/news?apikey=pub_15376dcf734b967c316e646bbd42efae591eb"

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(ScalarsConverterFactory.create())
        .baseUrl(apiUrl)
        .build()

    interface NewsApiServices {
        @GET("&q={type}&language=en")
        fun getNews(): String
    }

}