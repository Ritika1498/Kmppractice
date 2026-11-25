package com.codeturtle.kmppractice.di

import com.codeturtle.kmppractice.network.HttpClientProvider
import org.koin.dsl.module
import io.ktor.client.HttpClient

val networkModule = module {

    single<HttpClient> {
        HttpClientProvider.client
    }

}