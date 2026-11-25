package com.codeturtle.kmppractice.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(
    onUserClick: (Int) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Text(
            text = "Home Screen",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(20.dp))

        repeat(5) { index ->

            val userId = index + 1

            Button(
                onClick = {
                    onUserClick(userId)
                }
            ) {
                Text("Open User $userId")
            }

            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}