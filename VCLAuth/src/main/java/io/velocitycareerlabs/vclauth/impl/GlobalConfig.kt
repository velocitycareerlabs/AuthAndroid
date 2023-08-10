/**
 * Created by Michael Avoyan on 17/05/2022.
 *
 * Copyright 2022 Velocity Career Labs inc.
 * SPDX-License-Identifier: Apache-2.0
 */
package io.velocitycareerlabs.vclauth.impl

import io.velocitycareerlabs.vclauth.BuildConfig

object GlobalConfig {

    val IsDebug = BuildConfig.DEBUG

    const val LogTagPrefix = "VCLAuth "

    val IsLoggerOn get() = IsDebug
}