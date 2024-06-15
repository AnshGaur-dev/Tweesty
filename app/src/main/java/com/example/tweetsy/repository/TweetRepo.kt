package com.example.tweetsy.repository
//yeah repo h decide karegi data kaha se aayega(yaha sirf api laa rahi h)
import com.example.tweetsy.api.TweetsyApi
import com.example.tweetsy.models.TweetListItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class TweetRepo @Inject constructor(private val tweetsyApi: TweetsyApi) {


    private val _category =
        MutableStateFlow<List<String>>(emptyList())// yaha live data use ho raha h abhi emptylist use ki h jab naya data aayega to changes ho gaye isme
    val category: StateFlow<List<String>>
        //yeah _category ki copy hi samj lo becoz _category pvt h and uska data yeahi set ho sakta h aab iss class k bahar action perform karene k liye yeah h
        get() = _category

    suspend fun getCategories() {
        val response = tweetsyApi.getCategories()
        if (response.isSuccessful && response.body() != null) {
            _category.emit(response.body()!!)// this code update the new data in list?

        }
    }

    private val _tweets = MutableStateFlow<List<TweetListItem>>(emptyList())
    val tweets: StateFlow<List<TweetListItem>>
        get() = _tweets

    suspend fun gettweets(category: String) {
        val response = tweetsyApi.getTweets("tweets[?(@.category==\"$category\")]")
        if (response.isSuccessful && response.body() != null) {
            _tweets.emit(response.body()!!)
        }
    }
}