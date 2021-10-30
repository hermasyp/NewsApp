package com.catnip.newsapp.di

import androidx.room.Room
import com.catnip.newsapp.BuildConfig
import com.catnip.newsapp.data.local.room.AppDatabase
import com.catnip.newsapp.data.network.NewsApiService
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
Written with love by Muhammad Hermas Yuda Pamungkas
Github : https://github.com/hermasyp
 **/
val databaseModule = module {
    factory { get<AppDatabase>().newsDao() }
    single {
        Room.databaseBuilder(
            androidContext(),
            AppDatabase::class.java, "News.db"
        ).fallbackToDestructiveMigration().build()
    }
}
val networkModule = module {
    single {
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .addInterceptor(Interceptor {
                var original = it.request()
                val url = original.url.newBuilder().addQueryParameter("apiKey", BuildConfig.API_KEY)
                    .build()
                original = original.newBuilder().url(url).build()
                it.proceed(original)
            })
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .build()
    }
    single {
        val retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
        retrofit.create(NewsApiService::class.java)
    }

}
