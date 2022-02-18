package com.compose.instagram.home.presentation.composable

import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.compose.instagram.home.data.HomeRepository
import com.compose.instagram.home.domain.model.Publication
import com.compose.instagram.home.domain.model.Story
import com.compose.instagram.home.presentation.IMainContract
import com.compose.instagram.ui.theme.InstagramTheme

///////////////////////////////////////////////////////////////////////////
// COMPOSABLE
///////////////////////////////////////////////////////////////////////////

@Composable
fun HomeScreen(
    viewModel: IMainContract.ViewModel,
    event: IMainContract.ViewEvent.AppBar
) {
    Scaffold(
        topBar = { HomeTopAppBar(event = event) }
    ) { contentPadding ->
        // Screen content
        Box(modifier = Modifier.padding(contentPadding)) {
            Column {
                Spacer(modifier = Modifier.height(8.dp))
                StoriesView(viewModel = viewModel)
                Divider(
                    color = Color.Gray,
                    thickness = 0.3.dp,
                    modifier = Modifier.padding(vertical = 12.dp)
                )
                PublicationsView(viewModel = viewModel)
            }
        }
    }
}


@Composable
fun StoriesView(
    viewModel: IMainContract.ViewModel,
    modifier: Modifier = Modifier
) {
    val stories: List<Story> by viewModel.stories.observeAsState(initial = listOf())
    LazyRow(modifier = modifier.fillMaxWidth()) {
        items(stories) { story ->
            StoryItem(story = story, onClickStory = {})
        }
    }
}

@Composable
fun PublicationsView(
    viewModel: IMainContract.ViewModel,
    modifier: Modifier = Modifier
) {
    val publications: List<Publication> by viewModel.publications.observeAsState(initial = listOf())
    LazyColumn(modifier = modifier.fillMaxWidth()) {
        items(publications) {
            PublicationItem(publication = it)
        }
    }
}


///////////////////////////////////////////////////////////////////////////
// PREVIEW
///////////////////////////////////////////////////////////////////////////

@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    name = "DefaultPreviewDark"
)
@Composable
fun defaultPreview() {
    InstagramTheme {
        HomeScreen(
            viewModel = object : IMainContract.ViewModel {
                override val stories: LiveData<List<Story>>
                    get() = MutableLiveData(HomeRepository.fakeStories)

                override val publications: LiveData<List<Publication>>
                    get() = MutableLiveData(HomeRepository.fakePublications)

                override fun getPublications() {}
            },
            event = object : IMainContract.ViewEvent.AppBar {}
        )
    }
}