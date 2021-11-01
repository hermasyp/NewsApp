package com.catnip.newsapp.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.catnip.newsapp.data.network.response.News

/**
Written with love by Muhammad Hermas Yuda Pamungkas
Github : https://github.com/hermasyp
 **/
@Entity(
    tableName = "news", indices = [Index(
        value = ["url"],
        unique = true
    )]
)
data class News(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(name = "published_at")
    var publishedAt: String,
    @ColumnInfo(name = "author")
    var author: String,
    @ColumnInfo(name = "url_to_image")
    var urlToImage: String,
    @ColumnInfo(name = "description")
    var description: String,
    @ColumnInfo(name = "title")
    var title: String,
    @ColumnInfo(name = "url")
    var url: String,
    @ColumnInfo(name = "content")
    var content: String
) {
    constructor(networkItem: News) : this(
        publishedAt = networkItem.publishedAt.orEmpty(),
        author = networkItem.author.orEmpty(),
        urlToImage = networkItem.urlToImage.orEmpty(),
        description = networkItem.description.orEmpty(),
        title = networkItem.title.orEmpty(),
        url = networkItem.url.orEmpty(),
        content = networkItem.content.orEmpty(),
    )
}
