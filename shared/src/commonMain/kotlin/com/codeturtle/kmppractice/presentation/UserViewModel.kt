package com.codeturtle.kmppractice.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codeturtle.kmppractice.domain.GetUsersUseCase
import com.codeturtle.kmppractice.domain.User
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class UserViewModel(
    private val getUsersUseCase: GetUsersUseCase
) : ViewModel() {

    private val _users = MutableStateFlow<List<User>>(emptyList())
    val users = _users.asStateFlow()

    fun loadUsers() {
        viewModelScope.launch {
            _users.value = getUsersUseCase()
        }
    }
}