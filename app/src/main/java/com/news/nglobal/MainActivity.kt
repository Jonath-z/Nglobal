package com.news.nglobal

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.news.nglobal.network.ApiServices

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<ImageView>(R.id.main_imageView).setImageResource(R.drawable.welcome_prof)
        findViewById<Button>(R.id.button_home).setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }

        println("activity lunched")

        ApiServices().fetchNews("sport")
    }
}