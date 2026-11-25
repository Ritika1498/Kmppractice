package com.codeturtle.kmppractice.presentation

import com.codeturtle.kmppractice.domain.GetUsersUseCase
import com.codeturtle.kmppractice.domain.User

sealed interface UserUiState {
    data object Loading : UserUiState

    data class Success(
        val users: List<User>
    ) : UserUiState

    data class Error(
        val message: String
    ) : UserUiState
}