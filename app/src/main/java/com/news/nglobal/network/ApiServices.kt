package com.news.nglobal.network

import okhttp3.*
import java.io.IOException

class ApiServices {
    private val client = OkHttpClient()

    var failedToLoadNews: Boolean = false;

    fun fetchNews(url: String){
        val request = Request.Builder().url(url).build()

        client.newCall(request).enqueue(object: Callback{
            override fun onFailure(call: Call, e: IOException) {
                failedToLoadNews = true;
            }

            override fun onResponse(call: Call, response: Response) {
                failedToLoadNews = false
                println("RESPONSE \n")
                println(response.body()?.string())
            }
        })
    }
}