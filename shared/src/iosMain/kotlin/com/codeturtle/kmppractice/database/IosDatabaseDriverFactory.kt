package com.codeturtle.kmppractice.database


import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import com.codeturtle.kmppractice.db.AppDatabase

class IosDatabaseDriverFactory : DatabaseDriverFactory {

    override fun createDriver(): SqlDriver {
        return NativeSqliteDriver(
            schema = AppDatabase.Schema,
            name = "app.db"
        )
    }
}