package com.codeturtle.kmppractice.di

import com.codeturtle.kmppractice.data.UserApi
import com.codeturtle.kmppractice.data.UserRepositoryImpl
import com.codeturtle.kmppractice.domain.GetUsersUseCase
import com.codeturtle.kmppractice.domain.UserRepository
import com.codeturtle.kmppractice.presentation.UserViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module
import org.koin.plugin.module.dsl.viewModel
import kotlin.coroutines.EmptyCoroutineContext.get

val userModule = module {

    single {
        UserApi(get())
    }

    single<UserRepository> {
        UserRepositoryImpl(
            get(),
            localDataSource = get()
        )
    }

    factory {
        GetUsersUseCase()
    }

    viewModel {
        UserViewModel(
            getUsersUseCase = get()
        )
    }

}