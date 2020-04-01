package com.aminography.interceptor.sample

import android.os.Bundle
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
            override fun onDelayFinished(text: String?) {
                textView.text = String.format("%s\nIntercepted Text: %s", textView.text, text)
            }
        })
    }

}
