package dev.olaore.learningcompose.ui.components

import android.graphics.Color.parseColor
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.olaore.learningcompose.NewsItem
import dev.olaore.learningcompose.R
import dev.olaore.learningcompose.data.SampleData
import dev.olaore.learningcompose.ui.theme.WHITE

@Preview
@Composable
fun PreviewNewsList() {
    Row(modifier = Modifier.padding(8.dp)) {
        NewsList(items = SampleData.NEWS)
    }
}


@Composable
fun NewsList(items: List<NewsItem>) {
    Item(item = items[0])
}

@Composable
fun Item(item: NewsItem) {
    Image(
        painter = painterResource(R.drawable.profile_picture),
        contentDescription = "This is an image.",
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp),
        contentScale = ContentScale.Crop,
        alignment = Alignment.Center
    )
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
            .background(Color(parseColor("#80000000")))
    ) {
        Column(
            verticalArrangement = Arrangement.Bottom,
            modifier = Modifier
                .padding(8.dp)
                .height(150.dp)
        ) {
            Text("Something went wrong, bro!", fontSize = 24.sp, color = WHITE)
            Text("No author provided", fontSize = 18.sp, color = WHITE)
        }
    }
}