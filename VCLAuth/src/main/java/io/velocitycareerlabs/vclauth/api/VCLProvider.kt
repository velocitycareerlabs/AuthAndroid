/**
 * Created by Michael Avoyan on 17/05/2022.
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