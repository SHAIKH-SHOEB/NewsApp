package com.noob.newsapp

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

const val BASE_URL = "https://newsapi.org/"
const val API_Key = "60e574de4df5428383f2bb1846924ad9"

//https://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=60e574de4df5428383f2bb1846924ad9
interface NewsInterface {
    @GET("v2/top-headlines?apiKey=$API_Key")
    fun getHeadLine(@Query("country") country: String, @Query("page") page: Int): Call<News>
}

object NewsService {
    val newsInterface: NewsInterface

    init {
        val retrofit: Retrofit =
            Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
                .build()
        newsInterface = retrofit.create(NewsInterface::class.java)
    }
}