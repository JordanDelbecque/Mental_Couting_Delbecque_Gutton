package com.example.mentalcounting;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class ScoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.score);


        Button previousButton = findViewById(R.id.previous_button);
        previousButton.setOnClickListener(view -> goToPreviousActivity());
    }

    private void goToPreviousActivity() {
        finish();
    }
}