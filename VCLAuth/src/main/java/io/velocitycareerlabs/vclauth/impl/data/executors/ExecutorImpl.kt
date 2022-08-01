/**
 * Created by Michael Avoyan on 17/05/2022.
 */
package io.velocitycareerlabs.vclauth.impl.data.executors

import android.os.Handler
import android.os.Looper
import io.velocitycareerlabs.vclauth.impl.domain.executors.Executor
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

class ExecutorImpl: Executor {

    private val mainThread: Handler = Handler(Looper.getMainLooper())
    private val backgroundThreadPool: ExecutorService = Executors.newFixedThreadPool(10)

    override fun runOn(looper: Looper?, runnable: Runnable) {
        looper?.let {
            Handler(it).post {
                runnable.run()
            }
        } ?: run{ runnable.run() }
    }

    override fun runOnMainThread(runnable: Runnable) {
        mainThread.post {
            runnable.run()
        }
    }

    override fun runOnBackgroundThread(runnable: Runnable) {
        backgroundThreadPool.submit {
            runnable.run()
        }
    }

    override fun waitForTermination() {
        backgroundThreadPool.shutdown()
        backgroundThreadPool.awaitTermination(Long.MAX_VALUE, TimeUnit.SECONDS)
    }
}