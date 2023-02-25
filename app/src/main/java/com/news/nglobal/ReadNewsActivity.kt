package com.news.nglobal

import android.annotation.SuppressLint
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.news.nglobal.models.NewsViewModel

class ReadNewsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_read_news)

        window.statusBarColor = ContextCompat.getColor(this, R.color.white)
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        }

        val news = intent.getSerializableExtra("news") as NewsViewModel

        val title = findViewById<TextView>(R.id.read_article_title_view)
         title.text = news.title
        val image = findViewById<ImageView>(R.id.read_article_image_view)
        Glide.with(this).load(news.urlToImage).into(image)
        val content = findViewById<TextView>(R.id.read_article_content_view)
        content.text = news.content
        val author = findViewById<TextView>(R.id.read_article_author_view)
        author.text = news.author
    }
}