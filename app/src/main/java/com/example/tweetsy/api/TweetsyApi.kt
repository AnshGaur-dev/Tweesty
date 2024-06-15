package com.example.tweetsy.api

import com.example.tweetsy.models.TweetListItem

import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.Response
import retrofit2.http.Headers


interface TweetsyApi {

    @GET("v3/b/666a746ae41b4d34e40294bb?meta=false")//defining end point
                            //
    suspend  fun getTweets(@Header("X-JSON-Path") category: String):Response<List<TweetListItem>>

     @GET("v3/b/666a746ae41b4d34e40294bb?meta=false")
     @Headers("X-JSON-Path:tweets..category")
     suspend fun getCategories():Response<List<String>>// iss fun se sari category mil jaye or yaha dynamic value nhi aa rahi upar vale fun jese toh issliye yeah static h or header upar laagega sath mhi jayuega
}

