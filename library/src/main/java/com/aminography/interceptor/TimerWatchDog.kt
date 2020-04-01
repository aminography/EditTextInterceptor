package com.aminography.interceptor

import java.util.*

/**
 * @author aminography
 */
internal class TimerWatchDog(private val timeout: Long) {

    private var timer: Timer? = null
    private lateinit var toDoJob: (() -> Unit)

    internal fun refresh(job: () -> Unit) {
        toDoJob = job
        timer?.cancel()
        timer = Timer()
        timer?.schedule(object : TimerTask() {
            override fun run() = toDoJob.invoke()
        }, timeout)
    }

    internal fun cancel() = timer?.cancel()

}
