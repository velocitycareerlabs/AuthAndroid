/**
 * Created by Michael Avoyan on 17/05/2022.
 *
 * Copyright 2022 Velocity Career Labs inc.
 * SPDX-License-Identifier: Apache-2.0
 */
package io.velocitycareerlabs.vclauth.api

import io.velocitycareerlabs.vclauth.impl.VCLAuthImpl
import io.velocitycareerlabs.vclauth.impl.data.executors.ExecutorImpl

class VclAuthProvider {
    companion object {
        fun instance(): VCLAuth {
            return VCLAuthImpl(ExecutorImpl())
        }
    }
}