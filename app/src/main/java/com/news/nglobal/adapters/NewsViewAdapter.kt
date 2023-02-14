package com.news.nglobal.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.news.nglobal.NewsActivity
import com.news.nglobal.R
import com.news.nglobal.interfaces.NewsClickListener
import com.news.nglobal.models.NewsViewModel


class NewsViewAdapter(private val newsList: List<NewsViewModel>, private val context: NewsActivity): RecyclerView.Adapter<NewsViewAdapter.NewsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.news_activity_card, parent,false)
        return NewsViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val newsInView = newsList[position]

        // bind the image url with GLIDE library
        Glide.with(context).load(newsInView.urlToImage).into(holder.imageView)
        holder.title.text = newsInView.title
    }


    override fun getItemCount(): Int {
        return newsList.size
    }


    class NewsViewHolder(newsView: View): RecyclerView.ViewHolder(newsView){
        var imageView: ImageView = newsView.findViewById(R.id.newsImageView)
        var title: TextView = newsView.findViewById(R.id.newsTitleView)
    }

}

