/**
 * Created by Michael Avoyan on 17/05/2022.
 *
 * Copyright 2022 Velocity Career Labs inc.
 * SPDX-License-Identifier: Apache-2.0
 */

package io.velocitycareerlabs.vclauth.api

import android.content.Context
import androidx.fragment.app.FragmentActivity
import io.velocitycareerlabs.vclauth.api.entities.VCLAuthConfig

interface VCLAuth {
    /**
     * Checks if authentication is available on the device
     */
    fun isAuthenticationAvailable(
        context: Context,
        successHandler: (Boolean) -> Unit,
        errorHandler: (VCLError) -> Unit
    )

    /**
     * Displays a authentication identification dialog with provided configurations
     */
    fun authenticate(
        activity: FragmentActivity,
        authConfig: VCLAuthConfig,
        successHandler: (Boolean) -> Unit,
        errorHandler: (VCLError) -> Unit
    )

    /**
     * Invalidates a authentication identification dialog
     */
    fun cancelAuthentication()

    /**
     * Navigates to device's security settings screen for authentication setup
     */
    fun openSecuritySettings(
        context: Context,
        successHandler: (Boolean) -> Unit,
        errorHandler: (VCLError) -> Unit
    )
}