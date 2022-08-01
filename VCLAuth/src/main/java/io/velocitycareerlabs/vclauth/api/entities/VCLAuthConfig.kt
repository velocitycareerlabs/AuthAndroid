/**
 * Created by Michael Avoyan on 17/05/2022.
 */

package io.velocitycareerlabs.vclauth.api.entities

import androidx.biometric.BiometricPrompt

data class VCLAuthConfig(
    val title: String,
    val subtitle: String = "",
    val description: String = "",
    val cryptoObject: BiometricPrompt.CryptoObject? = null,
    val isConfirmationRequired: Boolean = true
)