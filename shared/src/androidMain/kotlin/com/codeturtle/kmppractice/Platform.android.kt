package com.codeturtle.kmppractice

import android.os.Build

actual class Platform actual constructor() {

    actual fun getPlatformName(): String {
        return "Android"
    }
}