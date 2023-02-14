package com.news.nglobal.interfaces

import com.news.nglobal.models.NewsViewModel

interface NewsClickListener {
    fun onClick(news: NewsViewModel)
}