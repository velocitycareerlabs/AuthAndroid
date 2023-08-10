/**
 * Created by Michael Avoyan on 17/05/2022.
 *
 * Copyright 2022 Velocity Career Labs inc.
 * SPDX-License-Identifier: Apache-2.0
 */

package io.velocitycareerlabs.vclauth.api.entities

import androidx.biometric.BiometricPrompt

data class VCLAuthConfig(
    val title: String,
    val subtitle: String = "",
    val description: String = "",
    val cryptoObject: BiometricPrompt.CryptoObject? = null,
    val isConfirmationRequired: Boolean = false
)