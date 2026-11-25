package com.codeturtle.kmppractice

import platform.UIKit.UIDevice

actual class Platform actual constructor() {

    actual fun getPlatformName(): String {
        return "ios"
    }
}