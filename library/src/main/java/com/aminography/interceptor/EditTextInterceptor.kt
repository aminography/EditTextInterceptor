package com.aminography.interceptor

import android.os.Handler
import android.text.Editable
import android.text.TextWatcher

/**
 * @author aminography
 */
abstract class EditTextInterceptor(delay: Long) : TextWatcher {

    private val watchDog = TimerWatchDog(delay)
    private val handler = Handler()

    abstract fun onDelayFinished(text: String?)

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
    }

    override fun afterTextChanged(s: Editable?) {
        watchDog.refresh {
            handler.post {
                onDelayFinished(s.toString())
            }
        }
    }

    fun cancel() = watchDog.cancel()

}
