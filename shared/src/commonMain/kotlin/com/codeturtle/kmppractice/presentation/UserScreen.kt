package com.codeturtle.kmppractice.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun UserScreen(
    viewModel: UserViewModel = koinViewModel(),
    onUserClick: (Int) -> Unit
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Column {

        Button(
            onClick = { viewModel.refreshUsers() },
            enabled = !uiState.isRefreshing
        ) {
            Text(
                if (uiState.isRefreshing) "Refreshing..."
                else "Refresh Users"
            )
        }

        uiState.error?.let { error ->
            Text(
                text = error,
                color = MaterialTheme.colorScheme.error
            )
        }

        if (uiState.isLoading && uiState.users.isEmpty()) {
            CircularProgressIndicator()
        } else {
            LazyColumn {
                items(
                    items = uiState.users,
                    key = { it.id }
                ) { user ->
                    Text(
                        text = user.name,
                        modifier = Modifier.clickable {
                            onUserClick(user.id)
                        }
                    )
                }
            }
        }
    }
}

