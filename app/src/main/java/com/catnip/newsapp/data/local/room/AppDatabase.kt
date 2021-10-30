package com.catnip.newsapp.data.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.catnip.newsapp.data.local.entity.News
import com.catnip.newsapp.data.local.room.dao.NewsDao

/**
Written with love by Muhammad Hermas Yuda Pamungkas
Github : https://github.com/hermasyp
 **/

@Database(entities = [News::class],version = 1)
abstract class AppDatabase : RoomDatabase(){
    abstract fun newsDao() : NewsDao
}