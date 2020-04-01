package com.aminography.interceptor

import java.util.*

/**
 * @author aminography
 */
internal class TimerWatchDog(private val timeout: Long) {

    private var timer: Timer? = null

    internal fun refresh(job: () -> Unit) {
        timer?.cancel()
        timer = Timer()
        timer?.schedule(object : TimerTask() {
            override fun run() = job.invoke()
        }, timeout)
    }

    internal fun cancel() = timer?.cancel()

}
