package dev.olaore.learningcompose.ui.layouts

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import dev.olaore.learningcompose.ui.layouts.ui.theme.LearningComposeTheme

class ConstraintLayoutActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearningComposeTheme {
                ConstraintLayoutContent()
            }
        }
    }
}

@Composable
fun ConstraintLayoutContent() {
    ConstraintLayout(
        modifier = Modifier.padding(20.dp)
    ) {

        val (button, text) = createRefs()

        Button(
            onClick = {},
            modifier = Modifier.constrainAs(button) {
                linkTo(
                    top = parent.top, start = parent.start,
                    end = parent.end, bottom = parent.bottom
                )
            }
        ) {
            Text("Button")
        }

        Text("Text", modifier = Modifier.constrainAs(text) {
            top.linkTo(button.bottom, margin = 16.dp)
            centerHorizontallyTo(parent)
        })

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview3() {
    LearningComposeTheme {
        ConstraintLayoutContent()
    }
}