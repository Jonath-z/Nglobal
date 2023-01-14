package com.news.nglobal

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.news.nglobal.network.ApiServices

class HomeActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.home_activity)

        ApiServices().fetchNews("this should be a api url")

        if(ApiServices().failedToLoadNews){
             // If it fails to load news
        }else{
            // update UI
        }
    }
}