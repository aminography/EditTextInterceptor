package com.aminography.interceptor

import android.os.Handler
import android.text.Editable
import android.text.TextWatcher

/**
 * @author aminography
 */
abstract class EditTextInterceptor(timeout: Long) : TextWatcher {

    private val watchDog = TimerWatchDog(timeout)
    private val handler = Handler()
    private var stopWatching = false

    abstract fun onInterceptText(text: String, isTyping: Boolean)

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
    }

    override fun afterTextChanged(s: Editable?) {
        if (!stopWatching) {
            onInterceptText(s?.toString() ?: "", true)
            watchDog.refresh {
                handler.post { onInterceptText(s?.toString() ?: "", false) }
            }
        }
    }

    fun stopWatching() {
        watchDog.cancel()
        stopWatching = true
    }

    fun resumeWatching() {
        stopWatching = false
    }

}
