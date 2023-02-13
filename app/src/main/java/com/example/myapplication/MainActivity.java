package com.example.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText text;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = findViewById(R.id.text_input);
        textView = findViewById(R.id.text);
        textView.setTextColor(Color.BLACK);
        Button button = findViewById(R.id.button);
        button.setBackgroundColor(Color.BLUE);

        button.setOnClickListener(view -> {
            final String input = text.getText().toString();
            if (!input.isEmpty() && input.length() < 10 && Long.parseLong(input) > 0 && Long.parseLong(input) < 999999999) {
                textView.setText(NumberToEnglishConverter.convert(Integer.parseInt(input)));
            } else {
                textView.setText("Only from 0 to 999 999 999!");
            }
        });
    }
}