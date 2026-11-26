package com.codeturtle.kmppractice.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codeturtle.kmppractice.domain.GetUsersUseCase
import com.codeturtle.kmppractice.domain.User
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class UserViewModel(
    private val getUsersUseCase: GetUsersUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(UserUiState())
    val uiState: StateFlow<UserUiState> = _uiState.asStateFlow()

    init {
        observeUsers()
        refreshUsers()
    }

    private fun observeUsers() {
        viewModelScope.launch {
            getUsersUseCase()
                .collect { users ->

                    _uiState.update {
                        it.copy(
                            users = users,
                            isLoading = false
                        )
                    }
                }
        }
    }

    fun refreshUsers() {
        viewModelScope.launch {

            _uiState.update {
                it.copy(
                    isRefreshing = true,
                    error = null
                )
            }

            try {
                getUsersUseCase.refresh()
            } catch (exception: Exception) {

                _uiState.update {
                    it.copy(
                        error = exception.message
                            ?: "Unable to refresh users"
                    )
                }
            } finally {
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        isRefreshing = false
                    )
                }
            }
        }
    }
}