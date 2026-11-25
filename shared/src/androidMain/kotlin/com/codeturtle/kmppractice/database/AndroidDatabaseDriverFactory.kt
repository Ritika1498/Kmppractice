package com.codeturtle.kmppractice.database

import android.content.Context
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import com.codeturtle.kmppractice.db.AppDatabase

class AndroidDatabaseDriverFactory(
    private val context: Context
) : DatabaseDriverFactory {

    override fun createDriver(): SqlDriver {
        return AndroidSqliteDriver(
            schema = AppDatabase.Schema,
            context = context,
            name = "app.db"
        )
    }
}