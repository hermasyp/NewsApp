package com.catnip.newsapp.data.network

import com.catnip.newsapp.data.constant.Constant
import com.catnip.newsapp.data.network.response.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

/**
Written with love by Muhammad Hermas Yuda Pamungkas
Github : https://github.com/hermasyp
 **/
interface NewsApiService {

    @GET("everything")
    suspend fun searchUsers(
        @Query("q") query: String = Constant.BASE_QUERY_SEARCH_KEYWORD,
        @Query("page") page: Int,
        @Query("pageSize") pageSize : Int = Constant.PAGE_SIZE_PER_REQUEST
    ): NewsResponse

}