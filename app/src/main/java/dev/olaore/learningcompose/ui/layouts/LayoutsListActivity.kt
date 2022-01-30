package dev.olaore.learningcompose.ui.layouts

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import dev.olaore.learningcompose.ui.layouts.ui.theme.LearningComposeTheme
import kotlinx.coroutines.launch

class LayoutsListActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearningComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    LayoutsListActivityPreview()
                }
            }
        }
    }
}

@Composable
fun ImageItem(index: Int) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(10.dp)
    ) {
        Image(
            painter = rememberImagePainter(
                data = "https://developer.android.com/images/brand/Android_Robot.png"
            ), contentDescription = "This is an image",
            modifier = Modifier.size(50.dp)
        )
        Spacer(modifier = Modifier.width(10.dp))
        Text(text = "Text $index", style = MaterialTheme.typography.h6)
    }
}


@Preview(showBackground = true)
@Composable
fun LayoutsListActivityPreview() {

    val listSize: Int = 100
    val scrollState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    LearningComposeTheme {
        Column {
            Row {
                Button(onClick = {
                    coroutineScope.launch {
                        scrollState.animateScrollToItem(0)
                    }
                }, modifier = Modifier.weight(1f)) {
                    Text(text = "Scroll to top")
                }
                Button(onClick = {
                    coroutineScope.launch {
                        scrollState.animateScrollToItem(listSize - 1)
                    }
                }, modifier = Modifier.weight(1f)) {
                    Text(text = "Scroll to bottom")
                }
            }
            LazyColumn(state = scrollState) {
                items(listSize) {
                    ImageItem(index = it)
                }
            }
        }
    }
}