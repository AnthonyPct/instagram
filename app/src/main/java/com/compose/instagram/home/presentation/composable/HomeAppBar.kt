package com.compose.instagram.home.presentation.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AddBox
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.compose.instagram.R
import com.compose.instagram.home.presentation.IMainContract

///////////////////////////////////////////////////////////////////////////
// COMPONENT
///////////////////////////////////////////////////////////////////////////

@Composable
fun HomeTopAppBar(
    modifier: Modifier = Modifier,
    event: IMainContract.ViewEvent.AppBar
) {
    TopAppBar(
        title = {
            Image(
                painter = painterResource(id = R.drawable.ic_insta_title),
                contentDescription = "Instagram",
                colorFilter = ColorFilter.tint(MaterialTheme.colors.onPrimary),
                modifier = modifier.size(100.dp)
            )
        },
        actions = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    Icons.Outlined.AddBox,
                    contentDescription = "Ajouter",
                    tint = MaterialTheme.colors.onPrimary
                )
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    Icons.Outlined.FavoriteBorder,
                    contentDescription = "Activitée",
                    tint = MaterialTheme.colors.onPrimary
                )
            }
            IconButton(onClick = { event.onClickMessage() }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_instagram_direct),
                    contentDescription = "Message",
                    tint = MaterialTheme.colors.onPrimary,
                    modifier = modifier.size(24.dp)
                )
            }
        },
        backgroundColor = Color.Black
    )
}