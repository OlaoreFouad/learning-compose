package dev.olaore.learningcompose.ui.layouts

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.olaore.learningcompose.ui.layouts.ui.theme.LearningComposeTheme

class LayoutsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearningComposeTheme {
                Surface(color = MaterialTheme.colors.background) {
                }
            }
        }
    }
}

@Composable
fun PhotographerCard(modifier: Modifier = Modifier) {
    Row(
        modifier = Modifier.padding(10.dp)
    ) {
        Surface(
            modifier = Modifier.size(50.dp),
            color = MaterialTheme.colors.onSurface.copy(alpha = 0.2f),
            shape = CircleShape
        ) {
            // image goes here.
        }
        Spacer(modifier = Modifier.width(15.dp))
        Column(
            modifier = Modifier.align(CenterVertically)
        ) {
            Text("Fouad Olaore", fontWeight = FontWeight.Bold)
            CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                Text("3 minutes ago", style = MaterialTheme.typography.body2)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LearningComposeTheme {
        PhotographerCard()
    }
}