package com.news.nglobal

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.news.nglobal.adapters.NewsViewAdapter
import com.news.nglobal.models.NewsApiResponseModel
import okhttp3.*
import java.io.IOException
import java.net.URL

class NewsActivity: AppCompatActivity() {
    private val apiKey: String = "7aff92f70bff4da19772191bf3784ea6"
    private val baseUrl: String = "https://newsapi.org/v2/everything"
    private val client: OkHttpClient = OkHttpClient()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val loadNewsProgressBar: ProgressBar = findViewById(R.id.load_news_progressBar)

        val recyclerView: RecyclerView = findViewById(R.id.sport_recyclerview)

        recyclerView.layoutManager = LinearLayoutManager(this)


        fun fetchNews(theme: String) {
            loadNewsProgressBar.visibility = View.VISIBLE

            val request = Request.Builder().url(URL("$baseUrl?q=$theme&language=en&apiKey=$apiKey")).build()
            client.newCall(request).enqueue(object: Callback {
                override fun onFailure(call: Call, e: IOException) {
                    Log.d("api error", e.toString())
                }

                override fun onResponse(call: Call, response: Response) {
                    val data = Gson().fromJson(response.body()?.string(), NewsApiResponseModel::class.java)

                    this@NewsActivity.runOnUiThread(java.lang.Runnable {
                    loadNewsProgressBar.visibility = View.GONE
                    val adapter = NewsViewAdapter(data.articles, this@NewsActivity)
                    recyclerView.adapter = adapter
                    })
                }
            })

        }

        fetchNews("sport")

        val sportTV: TextView = findViewById(R.id.sport_tv)
        val politicTV: TextView = findViewById(R.id.politic_tv)
        val businessTV: TextView = findViewById(R.id.business_tv)
        val healthTV: TextView = findViewById(R.id.health_tv)
        val musicTV: TextView = findViewById(R.id.music_tv)
        val cinemaTV: TextView = findViewById(R.id.cinema_tv)

        val textViewList: List<TextView> = listOf(sportTV, politicTV, businessTV, healthTV, musicTV, cinemaTV)

        @SuppressLint("ResourceType")
        fun updateActiveThemeBackground(theme: String){
            for (textView in textViewList){
                if(textView.text == theme){
                    textView.background = getDrawable(R.drawable.rounded_corner_view)
                    textView.setTextColor(resources.getColor(R.color.white))
                }else{
                    textView.setBackgroundColor(resources.getColor(R.color.white))
                    textView.setTextColor(resources.getColor(R.color.gray))
                }
            }
        }


        sportTV.setOnClickListener {
            fetchNews("sport")
            updateActiveThemeBackground("Sports")
        }

        politicTV.setOnClickListener {
            fetchNews("politic")
            updateActiveThemeBackground("Politics")
        }

        businessTV.setOnClickListener {
            fetchNews("business")
            updateActiveThemeBackground("Business")
        }

        cinemaTV.setOnClickListener {
            fetchNews("cinema")
            updateActiveThemeBackground("Cinema")
        }

        healthTV.setOnClickListener {
            fetchNews("health")
            updateActiveThemeBackground("Health")
        }

        musicTV.setOnClickListener {
            fetchNews("music")
            updateActiveThemeBackground("Music")
        }
    }
}


