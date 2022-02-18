package com.compose.instagram.home.presentation.composable

import android.content.res.Configuration
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.outlined.BookmarkBorder
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.ModeComment
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import coil.size.OriginalSize
import com.compose.instagram.R
import com.compose.instagram.home.domain.model.Publication
import com.compose.instagram.ui.theme.InstagramTheme
import com.compose.instagram.ui.theme.StoryStyle
import java.text.NumberFormat

///////////////////////////////////////////////////////////////////////////
// COMPOSABLE
///////////////////////////////////////////////////////////////////////////

@Composable
fun PublicationItem(
    modifier: Modifier = Modifier,
    publication: Publication
) {
    Column(
        modifier = modifier
            .background(MaterialTheme.colors.background)
            .padding(vertical = 5.dp)
    ) {
        PublicationHeader(
            name = publication.userName,
            picture = publication.userPicture,
            localisation = publication.localisation
        )
        PublicationContent(imageUrl = publication.content.first())
        PublicationActionButtons()
        PublicationDetails(
            publication.likes,
            publication.userName,
            publication.description,
            publication.comments
        )
    }
}

@Composable
fun PublicationHeader(
    modifier: Modifier = Modifier,
    name: String,
    localisation: String?,
    @DrawableRes picture: Int
) {
    Row(
        modifier = modifier
            .height(40.dp)
            .fillMaxWidth()
            .background(MaterialTheme.colors.background)
            .padding(horizontal = 6.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        RoundedImage(
            picture = picture,
            size = 30f,
            isRead = false,
        ) { /* GO TO PROFILE */ }
        Spacer(modifier = Modifier.width(10.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = name,
                style = StoryStyle.copy(fontSize = 13.sp),
                color = MaterialTheme.colors.onPrimary
            )
            localisation?.let {
                Text(
                    text = localisation,
                    style = StoryStyle.copy(fontSize = 9.sp),
                    color = MaterialTheme.colors.onPrimary
                )
            }
        }
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                Icons.Filled.MoreVert,
                "more",
                tint = MaterialTheme.colors.onPrimary
            )
        }
    }

}

@Composable
fun PublicationContent(
    modifier: Modifier = Modifier,
    imageUrl: String
) {
    Image(
        painter = rememberImagePainter(
            data = imageUrl,
            builder = {
                size(OriginalSize)
            }
        ),
        contentDescription = null,
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 6.dp)
    )
}

@Composable
fun PublicationActionButtons(
    modifier: Modifier = Modifier
) {
    Row(
        modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row {
            IconButton(
                onClick = { /*TODO*/ },
            ) {
                Icon(
                    Icons.Outlined.FavoriteBorder,
                    contentDescription = "Like",
                    tint = MaterialTheme.colors.onPrimary,
                )
            }
            IconButton(
                onClick = { /*TODO*/ },
            ) {
                Icon(
                    Icons.Outlined.ModeComment,
                    contentDescription = "Comment",
                    tint = MaterialTheme.colors.onPrimary,
                )
            }
            IconButton(
                onClick = { /*TODO*/ },
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_instagram_direct),
                    contentDescription = "Message",
                    tint = MaterialTheme.colors.onPrimary,
                    modifier = Modifier.size(20.dp)
                )
            }
        }
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                Icons.Outlined.BookmarkBorder,
                contentDescription = "Save",
                tint = MaterialTheme.colors.onPrimary,
                modifier = Modifier
                    .size(20.dp)
                    .weight(1f)
            )
        }
    }
}

@Composable
fun PublicationDetails(likes: Int, username: String, description: String, comments: List<String>) {
    Column(modifier = Modifier.padding(start = 12.dp)) {
        Text(
            text = "${NumberFormat.getInstance().format(likes)} J'aime",
            fontWeight = FontWeight.Bold
        )
        Text(
            modifier = Modifier.padding(end = 40.dp),
            text = buildAnnotatedString {
                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append(username)
                }
                append(" ")
                append(description)
            },
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )
        if (comments.isNotEmpty()) {
            Text(
//                text = "Voir les ${comments.size} commentaires",
                text = "Voir les 241 commentaires",
                color = Color.Gray,
                fontSize = 14.sp
            )
        }
        Spacer(modifier = Modifier.size(6.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            RoundedImage(picture = R.drawable.me, size = 30f, showBorder = false) {
                // DO NOTHING
            }
            Text(
                text = "Ajouter un commentaire...",
                color = Color.Gray,
                fontSize = 14.sp,
                modifier = Modifier.padding(start = 10.dp)
            )
        }
    }
}

///////////////////////////////////////////////////////////////////////////
// PREVIEW
///////////////////////////////////////////////////////////////////////////

@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    name = "Header",
    widthDp = 320
)
@Composable
private fun PreviewHeader() {
    InstagramTheme {
        PublicationHeader(
            name = "jeuxolympiques",
            picture = R.drawable.jo,
            localisation = "Rennes"
        )
    }
}

@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    name = "ActionButton",
    widthDp = 320,
    backgroundColor = 0x000000
)
@Composable
private fun PreviewActionButton() {
    InstagramTheme {
        PublicationActionButtons()
    }
}

@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    name = "description",
    widthDp = 320,
    backgroundColor = 0x000000
)
@Composable
private fun PreviewDescription() {
    InstagramTheme {
        PublicationDetails(
            likes = 12306,
            username = "jeuxolympiques",
            description = "Une belle journée à Pekin",
            comments = listOf("Aliagn Splendide, allez quentin")
        )
    }
}