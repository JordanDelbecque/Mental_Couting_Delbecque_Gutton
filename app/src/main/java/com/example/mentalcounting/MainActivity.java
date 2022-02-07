package com.example.mentalcounting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);

        Button mainButton = findViewById(R.id.game_button);
        Button scoreButton = findViewById(R.id.score_button);

        mainButton.setOnClickListener(view -> openGameActivity());
        scoreButton.setOnClickListener(view -> openScoreActivity());
    }

    private void openGameActivity() {
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
    }

    private void openScoreActivity() {
        Intent intent = new Intent(this, ScoreActivity.class);
        startActivity(intent);
    }


}