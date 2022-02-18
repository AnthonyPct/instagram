package com.compose.instagram.home.domain.usecase

import com.compose.instagram.home.data.IHomeRepository
import com.compose.instagram.home.domain.model.Publication
import com.compose.instagram.home.domain.model.Story
import toothpick.InjectConstructor
import javax.inject.Inject

@InjectConstructor
class GetPublicationUseCase {

    ///////////////////////////////////////////////////////////////////////////
    // DEPENDENCY
    ///////////////////////////////////////////////////////////////////////////

    @Inject
    lateinit var homeRepository: IHomeRepository

    ///////////////////////////////////////////////////////////////////////////
    // PUBLIC API
    ///////////////////////////////////////////////////////////////////////////

    suspend fun execute(): List<Publication> {
        return homeRepository.getPublications()
//
//        val unReadRandomStory = stories
//            .filter { it.isRead.not() }
//            .shuffled()
//        val readStory = stories.filter { it.isRead }
    }
}