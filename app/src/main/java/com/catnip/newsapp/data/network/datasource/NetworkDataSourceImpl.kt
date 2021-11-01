package com.catnip.newsapp.data.network.datasource

import com.catnip.newsapp.data.network.NewsApiService
import com.catnip.newsapp.data.network.response.NewsResponse

/**
Written with love by Muhammad Hermas Yuda Pamungkas
Github : https://github.com/hermasyp
 **/
class NetworkDataSourceImpl(val networkService: NewsApiService) : NetworkDataSource {
    override suspend fun getNews(page: Int): NewsResponse {
        return networkService.searchUsers(page = page)
    }
}