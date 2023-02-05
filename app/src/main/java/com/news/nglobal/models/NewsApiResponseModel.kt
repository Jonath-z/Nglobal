package com.news.nglobal.models

data class NewsApiResponseModel(
    val articles: List<NewsViewModel>,
    val status: String,
    val totalResults: Int
)
