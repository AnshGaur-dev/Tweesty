package com.example.tweetsy.ViewModel

//Yeah viewmodel h repo se data lekar UI layer pe dega
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tweetsy.repository.TweetRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(private val repo: TweetRepo) : ViewModel() {
    val categories: StateFlow<List<String>>
        get() = repo.category

    init {
        viewModelScope.launch {
            repo.getCategories()
        }
    }
//    Summary
//    When the ViewModel is created, the init block launches a coroutine that calls repo.getCategories().
//    The getCategories function fetches data from the API and updates _category.
//    The categories property exposes this updated data as a StateFlow to the UI.
//    The UI observes categories and updates itself whenever the data changes.
}