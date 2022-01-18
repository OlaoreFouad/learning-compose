package dev.olaore.learningcompose.ui.layouts

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Payment
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.olaore.learningcompose.R
import dev.olaore.learningcompose.ui.layouts.ui.theme.LearningComposeTheme

class LayoutsCodelabActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearningComposeTheme {
                LayoutsCodelab()
            }
        }
    }
}

@Composable
fun LayoutsCodelab() {
    Scaffold(
        topBar = LayoutCodelabTopBar,
        bottomBar = LayoutsCodelabBottomNav
    ) { innerPadding ->
        BodyContent(
            Modifier
                .padding(innerPadding)
        )
    }
}

val LayoutCodelabTopBar: @Composable () -> Unit = {
    TopAppBar(
        title = {
            Text("LayoutsCodelab")
        },
        actions = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Filled.Favorite,
                    contentDescription = "favorite"
                )
            }
        }
    )
}

@Composable
fun BodyContent(modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(8.dp)) {
        Text("Hi there!")
        Text("Thanks for taking the Layouts codelab with us!")
    }
}

val LayoutsCodelabBottomNav: @Composable () -> Unit = {
    BottomNavigation(
        modifier = Modifier,
        backgroundColor = colorResource(id = R.color.teal_700)
    ) {
        BottomBarNavItem(icon = Icons.Filled.Home, text = "Home")
        BottomBarNavItem(icon = Icons.Filled.Payment, text = "Payment")
        BottomBarNavItem(icon = Icons.Filled.Settings, text = "Settings")
    }
}

@Composable
fun BottomBarNavItem(
    icon: ImageVector,
    text: String
) {
    Column(
        modifier = Modifier
    ) {
        Icon(
            imageVector = icon,
            contentDescription = text,
            tint = colorResource(id = R.color.white)
        )
        Text(text, color = colorResource(id = R.color.white))
    }
}

@Composable
@Preview(showBackground = true)
fun LayoutsCodelabPreview() {
    LayoutsCodelab()
}