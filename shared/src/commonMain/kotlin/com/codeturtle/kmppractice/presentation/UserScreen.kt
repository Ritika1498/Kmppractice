package com.codeturtle.kmppractice.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun UserScreen(
    viewModel: UserViewModel = koinViewModel()
) {
    val users by viewModel.users.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.loadUsers()
    }

    LazyColumn {
        items(users) { user ->
            Text(
                text = user.name,
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}

