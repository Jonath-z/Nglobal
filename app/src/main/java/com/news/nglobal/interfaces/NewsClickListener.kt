package com.news.nglobal.interfaces

import com.news.nglobal.models.NewsViewModel

interface OnNewsClickListener {
    fun onNewsClick(news: NewsViewModel)
}