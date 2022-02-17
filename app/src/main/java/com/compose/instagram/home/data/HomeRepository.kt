package com.compose.instagram.home.data

import com.compose.instagram.R
import com.compose.instagram.home.domain.model.Story
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import toothpick.InjectConstructor

@InjectConstructor
class HomeRepository : IHomeRepository {

    companion object {

        ///////////////////////////////////////////////////////////////////////////
        // FAKE DATA
        ///////////////////////////////////////////////////////////////////////////

        val fakeStories = listOf(
            Story(0, "Votre story", R.drawable.me, false, listOf()),
            Story(1, "blackbearrennes", R.drawable.bb, false, listOf()),
            Story(2, "peakyblindersoff", R.drawable.peaky, false, listOf()),
            Story(3, "jeuxolympiques", R.drawable.jo, false, listOf()),
            Story(4, "blackbearrennes", R.drawable.bb, false, listOf()),
            Story(5, "peakyblindersoff", R.drawable.peaky, false, listOf()),
            Story(6, "jeuxolympiques", R.drawable.jo, false, listOf())
        )
    }

    ///////////////////////////////////////////////////////////////////////////
    // SPECIALIZATION
    ///////////////////////////////////////////////////////////////////////////

    override fun getPublications() {
    }

    override suspend fun getStories(): List<Story> {
        return withContext(Dispatchers.IO) {
            delay(1000) // simulate WS call duration
            fakeStories
        }
    }
}