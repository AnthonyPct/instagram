package com.compose.instagram.home.presentation.composable

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.compose.instagram.R
import com.compose.instagram.home.domain.model.Story
import com.compose.instagram.ui.theme.InstagramTheme
import com.compose.instagram.ui.theme.StoryStyle
import com.compose.instagram.ui.theme.TorchRed

@Composable
fun StoryItem(
    story: Story,
    onClickStory: (story: Story) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .size(75.dp)
            .background(MaterialTheme.colors.background),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = story.picture),
            contentDescription = "story ${story.userName}",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(60.dp)
                .clip(CircleShape)                       // clip to the circle shape
                .border(
                    if (story.id == 0) 0.dp else 2.dp,
                    if (story.isRead.not()) TorchRed else Color.Gray,
                    CircleShape
                )   // add a border (optional)
                .clickable { onClickStory(story) }
        )
        Text(
            text = story.userName,
            color = MaterialTheme.colors.onPrimary,
            style = StoryStyle,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.padding(horizontal = 6.dp)
        )
    }
}

@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    name = "DefaultPreviewDark"
)
@Composable
fun defaultStoryPreview() {
    InstagramTheme {
        StoryItem(
            story = Story(2, "peakyblindersoff", R.drawable.peaky, false, listOf()),
            onClickStory = {}
        )
    }
}