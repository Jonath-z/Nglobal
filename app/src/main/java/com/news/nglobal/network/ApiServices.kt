package com.news.nglobal.network

import android.util.Log
import okhttp3.*
import java.io.IOException
import java.net.URL

class ApiServices {
    private val apiKey: String = "7aff92f70bff4da19772191bf3784ea6"
    private val baseUrl: String = "https://newsapi.org/v2/everything"

    private val client: OkHttpClient = OkHttpClient()

    fun fetchNews(theme: String) {
        val request = Request.Builder().url(URL("$baseUrl?q=$theme&&apiKey=$apiKey")).build()

        client.newCall(request).enqueue(object: Callback{
            override fun onFailure(call: Call, e: IOException) {
                Log.d("api error", e.toString())
            }

            override fun onResponse(call: Call, response: Response) {
                Log.d("api response", response.toString())
            }
        })
    }
}