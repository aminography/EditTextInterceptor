package com.aminography.interceptor.sample

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.aminography.interceptor.EditTextInterceptor
import kotlinx.android.synthetic.main.activity_main.*

/**
 * @author aminography
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText.addTextChangedListener(object : EditTextInterceptor(500) {
            override fun onInterceptText(text: String, isTyping: Boolean) {
                typingTextView.visibility = if (isTyping) View.VISIBLE else View.INVISIBLE
                if (!isTyping) {
                    textView.text = String.format("%s\n➠ %s", textView.text, text).trim()
                }
            }
        })
    }

}
