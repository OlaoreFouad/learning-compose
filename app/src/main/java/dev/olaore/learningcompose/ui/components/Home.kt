package dev.olaore.learningcompose.ui.components

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import dev.olaore.learningcompose.R
import dev.olaore.learningcompose.ui.components.ui.theme.LearningComposeTheme

class Home : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}

@Composable
fun Greeting(name: String) {

    var expanded by remember { mutableStateOf(false) }
    val extraPadding = if (expanded) 48.dp else 0.dp

    Surface(
        color = MaterialTheme.colors.primary,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        Column {
            Row(
                modifier = Modifier
                    .padding(24.dp)
            ) {
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(bottom = extraPadding)
                ) {

                    Text(text = "Hello,", color = colorResource(id = R.color.white))
                    Text(text = name, color = colorResource(id = R.color.white))

                }
                OutlinedButton(
                    onClick = {
                        expanded = !expanded
                    },
                    modifier = Modifier.background(colorResource(id = R.color.white))
                ) {
                    Text(
                        text = "Show ${if (expanded) "Less" else "More"}",
                        color = colorResource(id = R.color.purple_500)
                    )
                }
            }
        }
    }
    Spacer(modifier = Modifier.height(4.dp))

}

@Composable
fun HomeScreen(onContinueClicked: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(colorResource(id = R.color.teal_700))
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Welcome to the Compose Basics app.", color = colorResource(id = R.color.white))
            Spacer(Modifier.height(8.dp))
            Button(
                onClick = onContinueClicked,
                modifier = Modifier.background(colorResource(id = R.color.teal_700))
            ) {
                Text("Click Me!", color = colorResource(id = R.color.white))
            }
        }

    }
}

@Preview
@Composable
fun PreviewHome() {
    val names = listOf("Fouad", "Nofiu", "Farhan")
    LearningComposeTheme {
        var shouldShowOnboarding by rememberSaveable { mutableStateOf(true) }

        if (shouldShowOnboarding) {
            HomeScreen {
                shouldShowOnboarding = false
            }
        } else {
            LazyColumn {
                items(items = names) { item ->
                    Greeting(name = item)
                }
            }
        }

    }
}
