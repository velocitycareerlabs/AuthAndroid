package io.velocitycareerlabs.vclauth.impl.domain.executors

import android.os.Looper

/**
 * Created by Michael Avoyan on 5/2/21.
 */
interface Executor {
    fun runOn(looper: Looper?, runnable: Runnable)
    fun runOnMainThread(runnable: Runnable)
    fun runOnBackgroundThread(runnable: Runnable)
    fun waitForTermination()
}