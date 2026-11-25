package com.codeturtle.kmppractice

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.codeturtle.kmppractice.di.sharedModules
import com.codeturtle.kmppractice.presentation.UserScreen
import com.codeturtle.kmppractice.presentation.UserViewModel
import org.jetbrains.compose.resources.painterResource

import kmppractice.shared.generated.resources.Res
import kmppractice.shared.generated.resources.compose_multiplatform
import org.koin.core.KoinApplication
import org.koin.dsl.koinConfiguration

@Composable
fun App() {

    org.koin.compose.KoinApplication(configuration = koinConfiguration(declaration = {
        modules(
            sharedModules
        )
    }), content = {
        AppContent()
    })
}

@Composable
fun AppContent() {
    MaterialTheme {
        UserScreen()
    }
}
@Composable
fun showScreen(viewModel: UserViewModel)
{
    val platform = Platform()
    MaterialTheme {
        var showContent by remember { mutableStateOf(false) }
        Column(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.primaryContainer)
                .safeContentPadding()
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Button(onClick = { showContent = !showContent }) {
                Text("Click me!")
                UserScreen(viewModel)
            }
            AnimatedVisibility(showContent) {
                val greeting = remember {platform.getPlatformName()}
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Image(painterResource(Res.drawable.compose_multiplatform), null)
                    Text("Compose: $greeting")
                }
            }
        }
    }
}
