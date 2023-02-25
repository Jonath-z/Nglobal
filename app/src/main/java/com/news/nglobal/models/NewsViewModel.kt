package com.news.nglobal.models

data class Source(
    val id: Any,
    val name: String
): java.io.Serializable


data class NewsViewModel(
    val author: String,
    val content: String,
    val description: String,
    val publishedAt: String,
    val source: Source,
    val title: String,
    val url: String,
    val urlToImage: String
): java.io.Serializable
