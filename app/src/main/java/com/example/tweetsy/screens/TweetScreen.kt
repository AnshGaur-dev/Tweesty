package com.example.tweetsy.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.tweetsy.ViewModel.CategoryViewModel
import com.example.tweetsy.ViewModel.TweetsViewModel
import com.example.tweetsy.models.TweetListItem

@Composable
fun TweetScreen (){
    val tweetsViewModel: TweetsViewModel = hiltViewModel() // Create CategoryViewModel instance to fetch items
    val tweets = tweetsViewModel.tweets.collectAsState()
    LazyColumn {
        items(tweets.value) { tweetItem ->
            TweetScreenListItem(tweet = tweetItem.text)
        }
    }
}
@Composable
fun TweetScreenListItem(tweet:String){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        border = BorderStroke(1.dp, Color.White),)
    {
        Text(text = tweet,
        modifier = Modifier.padding(16.dp), style = MaterialTheme.typography.bodyMedium
        )
    }
}