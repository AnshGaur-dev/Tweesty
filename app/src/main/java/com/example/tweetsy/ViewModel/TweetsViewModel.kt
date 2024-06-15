package com.example.tweetsy.ViewModel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tweetsy.models.TweetListItem
import com.example.tweetsy.repository.TweetRepo
import dagger.hilt.android.lifecycle.ActivityRetainedSavedState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TweetsViewModel @Inject constructor(private val repo: TweetRepo, private val savedStateHandle: SavedStateHandle) : ViewModel()  {
    val tweets: StateFlow<List<TweetListItem>>
        get() = repo.tweets

    init {
        viewModelScope.launch {
            val category=savedStateHandle.get<String>("category")?:"facts"
            repo.gettweets(category)
        }
    }
}