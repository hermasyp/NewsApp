package com.catnip.newsapp.data.local.datasource

import com.catnip.newsapp.data.local.entity.News
import com.catnip.newsapp.data.local.room.dao.NewsDao

/**
Written with love by Muhammad Hermas Yuda Pamungkas
Github : https://github.com/hermasyp
 **/
class LocalDataSourceImpl(val dao: NewsDao) : LocalDataSource {
    override suspend fun insertAll(news: List<News>) {
        dao.insertAll(news)
    }

    override suspend fun clearAll() {
        dao.clearAll()
    }
}