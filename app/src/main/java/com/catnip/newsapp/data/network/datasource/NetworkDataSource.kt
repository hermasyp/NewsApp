package com.catnip.newsapp.data.network.datasource

import com.catnip.newsapp.data.network.response.NewsResponse

/**
Written with love by Muhammad Hermas Yuda Pamungkas
Github : https://github.com/hermasyp
 **/
interface NetworkDataSource {
    suspend fun getNews(page : Int) : NewsResponse
}