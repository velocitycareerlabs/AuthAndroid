/**
 * Created by Michael Avoyan on 17/05/2022.
 */
package io.velocitycareerlabs.vclauth.impl

import io.velocitycareerlabs.vclauth.BuildConfig

object GlobalConfig {
    const val VclPackage = BuildConfig.LIBRARY_PACKAGE_NAME

    val IsDebug = BuildConfig.DEBUG

    const val LogTagPrefix = "VCLAuth "

    val IsLoggerOn get() = IsDebug

    // TODO: Will be remotely configurable
    var IsToLoadFromCacheInitialization = false
}