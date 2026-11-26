package com.codeturtle.kmppractice.di

import app.cash.sqldelight.db.SqlDriver
import com.codeturtle.kmppractice.database.DatabaseDriverFactory
import com.codeturtle.kmppractice.db.AppDatabase
import org.koin.dsl.module

val databaseModule = module {

    single<SqlDriver> {
        get<DatabaseDriverFactory>().createDriver()
    }
    single {
        AppDatabase(
            driver = get<SqlDriver>()
        )
    }
}