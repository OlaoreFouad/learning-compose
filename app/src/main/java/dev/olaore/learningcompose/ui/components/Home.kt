package dev.olaore.learningcompose.ui.components

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import dev.olaore.learningcompose.R
import dev.olaore.learningcompose.ui.components.ui.theme.LearningComposeTheme
import kotlin.math.exp

class Home : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val names = listOf("Fouad", "Olamide", "Olaore")
            LearningComposeTheme {
                var shouldShowOnboarding by rememberSaveable { mutableStateOf(false) }

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
    }
}

@Composable
fun Greeting(name: String) {

    var expanded by remember { mutableStateOf(false) }

    Card(
        backgroundColor = MaterialTheme.colors.primary,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        Column {
            Row(
                modifier = Modifier
                    .padding(24.dp)
                    .animateContentSize(
                        spring(
                            dampingRatio = Spring.DampingRatioMediumBouncy,
                            stiffness = Spring.StiffnessLow
                        )
                    )
            ) {
                Column(
                    modifier = Modifier
                        .weight(1f)
                ) {

                    Text(text = "Hello,", color = colorResource(id = R.color.white))
                    Text(text = name, color = colorResource(id = R.color.white))

                    if (expanded) {
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(text = stringResource(R.string.lorem_ipsum_text))
                    }

                }
                IconButton(onClick = {
                    expanded = !expanded
                }) {
                    Icon(
                        imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
                        contentDescription = if (expanded) stringResource(R.string.show_less_text) else stringResource(
                            R.string.show_more_text
                        )
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
        var shouldShowOnboarding by rememberSaveable { mutableStateOf(false) }

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
