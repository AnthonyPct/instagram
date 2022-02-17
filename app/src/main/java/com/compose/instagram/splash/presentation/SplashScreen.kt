package com.compose.instagram.splash.presentation

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.compose.instagram.R
import com.compose.instagram.ui.theme.Crusta
import com.compose.instagram.ui.theme.InstagramTheme
import com.compose.instagram.ui.theme.MineShaft
import com.compose.instagram.ui.theme.TorchRed
import kotlinx.coroutines.delay


///////////////////////////////////////////////////////////////////////////
// SCREEN STATE
///////////////////////////////////////////////////////////////////////////

enum class SplashState { Shown, Completed }

///////////////////////////////////////////////////////////////////////////
// COMPOSABLE
///////////////////////////////////////////////////////////////////////////

@Composable
fun SplashScreen(modifier: Modifier = Modifier, onFinish: () -> Unit) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(MineShaft),
    ) {
        val currentOnTimeout by rememberUpdatedState(onFinish)
        LaunchedEffect(Unit) {
            delay(2000)
            currentOnTimeout()
        }

        Image(
            modifier = Modifier
                .size(120.dp)
                .align(Alignment.Center)
                .padding(bottom = 20.dp),
            painter = painterResource(id = R.drawable.ic_instagram_round_line_color),
            contentDescription = "Logo"
        )
        FromMeta(modifier = Modifier.align(Alignment.BottomCenter))
    }
}

@Composable
fun FromMeta(modifier: Modifier) {
    Column(
        modifier = modifier.padding(bottom = 40.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "from", color = Color.Gray)
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                modifier = Modifier.size(25.dp),
                painter = painterResource(id = R.drawable.ic_facebook_new_logo_meta),
                contentDescription = "Logo facebook",
                colorFilter = ColorFilter.tint(Crusta)
            )
            Spacer(modifier = Modifier.width(6.dp))
            Text(
                text = "Meta",
                style = MaterialTheme.typography.h6,
                color = TorchRed
            )
        }
    }
}

@Preview(
    showBackground = true,
//    widthDp = 320,
    uiMode = UI_MODE_NIGHT_YES,
    name = "DefaultPreviewDark"
)
@Composable
fun splashPreview() {
    InstagramTheme {
        SplashScreen(onFinish = {})
    }
}