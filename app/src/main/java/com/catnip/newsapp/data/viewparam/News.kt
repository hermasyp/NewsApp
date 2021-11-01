package com.catnip.newsapp.data.viewparam

import android.os.Parcelable
import com.catnip.newsapp.data.local.entity.News
import kotlinx.parcelize.Parcelize

/**
Written with love by Muhammad Hermas Yuda Pamungkas
Github : https://github.com/hermasyp
 **/

@Parcelize
data class News(
    var publishedAt: String,
    var author: String,
    var urlToImage: String,
    var description: String,
    var title: String,
    var url: String,
    var content: String
) : Parcelable {
    constructor(entity: News) : this(
        publishedAt = entity.publishedAt.orEmpty(),
        author = entity.author.orEmpty(),
        urlToImage = entity.urlToImage.orEmpty(),
        description = entity.description.orEmpty(),
        title = entity.title.orEmpty(),
        url = entity.url.orEmpty(),
        content = entity.content.orEmpty(),
    )
}
