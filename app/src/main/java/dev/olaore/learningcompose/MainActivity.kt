package dev.olaore.learningcompose

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.olaore.learningcompose.data.SampleData
import dev.olaore.learningcompose.ui.components.NewsList
import dev.olaore.learningcompose.ui.theme.LearningComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearningComposeTheme() {
                NewsList(items = SampleData.NEWS)
            }
        }
    }
}

@Composable
fun MessageCard(message: Message) {

    Row(modifier = Modifier.padding(16.dp)) {
        Image(
            painter = painterResource(R.drawable.profile_picture),
            contentDescription = "This is the profile picture image!",
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape)
                .border(
                    border = BorderStroke(1.5.dp, MaterialTheme.colors.secondaryVariant),
                    shape = CircleShape
                ),
            contentScale = ContentScale.Crop,
            alignment = Center
        )

        var isExpanded by remember { mutableStateOf(false) }

        Spacer(modifier = Modifier.width(16.dp))
        Column(modifier = Modifier
            .align(CenterVertically)
            .clickable { isExpanded = !isExpanded }) {
            Text(
                message.author,
                color = MaterialTheme.colors.secondary,
                style = MaterialTheme.typography.body2
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                message.body,
                style = MaterialTheme.typography.subtitle2,
                maxLines = if (isExpanded) Int.MAX_VALUE else 1
            )
        }
    }

}

@Composable
fun Conversation(messages: List<Message>) {
    LazyColumn {
        items(messages) { message ->
            MessageCard(message)
        }
    }
}

@Preview
@Composable
fun PreviewConversation() {
    LearningComposeTheme {
        Conversation(messages = SampleData.MESSAGES)
    }
}

// models
data class Message(val author: String, val body: String)

data class NewsItem(val title: String, val author: String)