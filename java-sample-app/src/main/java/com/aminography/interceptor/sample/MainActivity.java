package com.aminography.interceptor.sample;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.aminography.interceptor.EditTextInterceptor;

import org.jetbrains.annotations.NotNull;

/**
 * @author aminography
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editText = findViewById(R.id.editText);
        final TextView textView = findViewById(R.id.textView);
        final TextView typingTextView = findViewById(R.id.typingTextView);

        editText.addTextChangedListener(new EditTextInterceptor(500) {
            @Override
            public void onInterceptText(@NotNull String text, boolean isTyping) {
                typingTextView.setVisibility(isTyping ? View.VISIBLE : View.INVISIBLE);
                if (!isTyping) {
                    textView.setText(String.format("%s\n➠ %s", textView.getText(), text).trim());
                }
            }
        });
    }

}
