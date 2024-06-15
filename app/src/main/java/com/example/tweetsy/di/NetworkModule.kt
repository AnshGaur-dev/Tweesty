package com.example.tweetsy.di
//YAHA RETROFIT KA OBJ+API KA OBJ BANAYA JA RAHA H
import com.example.tweetsy.api.TweetsyApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module// this means dagger class m involve h and uska hath h iss class ka object banane m
@InstallIn(SingletonComponent::class)// iska means puri lifecycle m single time hi baanega object
class NetworkModule {
    @Singleton
    @Provides
    fun providesRetrofit():Retrofit{
        return Retrofit.Builder().baseUrl("https://api.jsonbin.io/")
            .addConverterFactory(GsonConverterFactory.create()).build()
    }
    @Singleton
    @Provides
    fun provideTweestyApi(retrofit: Retrofit):TweetsyApi{
        return retrofit.create(TweetsyApi::class.java)
    }

}