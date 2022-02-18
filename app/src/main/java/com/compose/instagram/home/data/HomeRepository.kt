package com.compose.instagram.home.data

import com.compose.instagram.R
import com.compose.instagram.home.domain.model.Publication
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

        val fakePublications = listOf(
            Publication(
                userName = "jeuxolympiques",
                userPicture = R.drawable.jo,
                localisation = "Pekin",
                content = listOf(
                    "https://cdn.pixabay.com/photo/2017/04/20/20/27/ski-race-2246889_1280.jpg",
                    "https://cdn.pixabay.com/photo/2013/02/09/13/39/olympic-79693_1280.jpg"
                ),
                likes = 12304,
                description = "Une grosse journée à Pekin aujourd'hui ou la France remporte 2 médailles",
                comments = listOf("Aliagn Splendide, allez quentin")
            ),
            Publication(
                userName = "blackbearrennes",
                userPicture = R.drawable.bb,
                localisation = "Rennes",
                content = listOf("https://cdn.pixabay.com/photo/2020/03/18/21/47/ireland-4945565_1280.jpg"),
                likes = 206,
                description = "Ouverture spéciale à 12h30 ! Venez nombreux"
            )
        )
    }

    ///////////////////////////////////////////////////////////////////////////
    // SPECIALIZATION
    ///////////////////////////////////////////////////////////////////////////

    override suspend fun getPublications(): List<Publication> {
        return withContext(Dispatchers.IO) {
            delay(1000) // simulate WS call duration
            fakePublications
        }
    }

    override suspend fun getStories(): List<Story> {
        return withContext(Dispatchers.IO) {
            delay(1000) // simulate WS call duration
            fakeStories
        }
    }
}