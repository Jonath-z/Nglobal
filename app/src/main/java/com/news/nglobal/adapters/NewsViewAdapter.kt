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
import com.news.nglobal.interfaces.OnNewsClickListener
import com.news.nglobal.models.NewsViewModel
import okhttp3.Callback


class NewsViewAdapter(private val newsList: List<NewsViewModel>, private val context: NewsActivity): RecyclerView.Adapter<NewsViewAdapter.NewsViewHolder>() {
    interface OnNewsClickListener {
        fun onNewsClick(news: NewsViewModel)
    }

    private var listener: OnNewsClickListener? = null

    fun setOnNewsClickListener(listener: OnNewsClickListener) {
        this.listener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.news_activity_card, parent,false)
        return NewsViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val newsInView = newsList[position]
        holder.bindData(newsInView, context)
    }


    override fun getItemCount(): Int {
        return newsList.size
    }

    inner class NewsViewHolder(newsView: View): RecyclerView.ViewHolder(newsView){
        private val imageView: ImageView = newsView.findViewById(R.id.newsImageView)
        private val title: TextView = newsView.findViewById(R.id.newsTitleView)
        private val _newsView = newsView
        fun bindData(data: NewsViewModel, context: NewsActivity){
            // bind the image url with GLIDE library
            Glide.with(context).load(data.urlToImage).into(imageView)
            title.text = data.title
            _newsView.setOnClickListener{
                listener?.onNewsClick(data)
            }
        }
    }

}

