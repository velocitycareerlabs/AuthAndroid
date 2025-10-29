/**
 * Copyright 2022 Velocity Career Labs inc.
 * SPDX-License-Identifier: Apache-2.0
 *
 * Copyright 2022 Velocity Career Labs inc.
 * SPDX-License-Identifier: Apache-2.0
 */
package com.vcl.authandroid

import android.app.AlertDialog
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.vcl.authandroid.databinding.ActivityMainBinding
import io.velocitycareerlabs.vclauth.api.VclAuthProvider
import io.velocitycareerlabs.vclauth.api.entities.VCLAuthConfig

class MainActivity : AppCompatActivity() {

    private val TAG = "VCLAuth"

    private lateinit var binding: ActivityMainBinding

    private val vclAuth = VclAuthProvider.instance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAuthenticate.setOnClickListener {
            vclAuth.isAuthenticationAvailable(
                context = this,
                successHandler = { isAuthenticationAvailable ->
                    Log.d(TAG, "VCLAuth isAuthenticationAvailable: $isAuthenticationAvailable")
                    if (isAuthenticationAvailable) {
                        vclAuth.authenticate(
                            activity = this,
                            authConfig = VCLAuthConfig(
                                title = "The passcode you use to unlock this Phone, can also be used to access your Velocity account."
                            ),
                            successHandler = { isRecognized ->
                                Log.d(TAG, "VCLAuth User recognized: $isRecognized")
                            },
                            errorHandler = { error ->
                                Log.e(TAG, "VCLAuth error: $error")
                                showAlert("Auth error", error.message ?: "")
                            })
                    } else {
                        showAlert("Authentication is NOT Available","")
                    }
                },
                errorHandler = { error ->
                    Log.e(TAG, "VCLAuth isAuthenticationAvailable error: $error")
                    showAlert("isAuthenticationAvailable error", error.message ?: "")
                })
        }

        binding.btnOpenSecuritySettings.setOnClickListener {
            vclAuth.openSecuritySettings(
                this,
                successHandler = { isOpen ->
                    Log.d(TAG, "VCLAuth Security settings is open: $isOpen")
                },
                errorHandler = { error ->
                    Log.e(TAG, "VCLAuth Security settings open error: $error")
                })
        }
    }

    fun showAlert(title: String, message: String) {
        runOnUiThread{
            AlertDialog.Builder(this)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton(
                    "OK"
                ) { dialog, _ ->
                    dialog.dismiss()
                }
                .show()
        }
    }
}