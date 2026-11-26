package com.codeturtle.kmppractice.presentation

import com.codeturtle.kmppractice.domain.GetUsersUseCase
import com.codeturtle.kmppractice.domain.User

data class UserUiState(
    val users: List<User> = emptyList(),
    val isLoading: Boolean = true,
    val isRefreshing: Boolean = false,
    val error: String? = null
)