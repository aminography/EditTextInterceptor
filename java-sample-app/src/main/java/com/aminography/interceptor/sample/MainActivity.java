package com.aminography.interceptor.sample;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.aminography.interceptor.EditTextInterceptor;

import org.jetbrains.annotations.Nullable;

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

        editText.addTextChangedListener(new EditTextInterceptor(500) {
            @Override
            public void onDelayFinished(@Nullable String text) {
                textView.setText(String.format("%s\nIntercepted Text: %s", textView.getText(), text));
            }
        });
    }

}
