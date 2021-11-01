package com.catnip.newsapp.data.local.datasource

import com.catnip.newsapp.data.local.entity.News

/**
Written with love by Muhammad Hermas Yuda Pamungkas
Github : https://github.com/hermasyp
 **/
interface LocalDataSource {
    suspend fun insertAll(news: List<News>)
    suspend fun clearAll()
}