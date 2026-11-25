package com.codeturtle.kmppractice.database


import app.cash.sqldelight.db.SqlDriver

interface DatabaseDriverFactory {

    fun createDriver(): SqlDriver
}