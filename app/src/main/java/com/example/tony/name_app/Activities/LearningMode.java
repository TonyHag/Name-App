package com.example.tony.name_app.Activities;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tony.name_app.GameEngine;
import com.example.tony.name_app.R;

import static com.example.tony.name_app.LocalDatabase.getList;

public class LearningMode extends AppCompatActivity {
    GameEngine game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learning_mode);

        setTitle("Learning mode");

        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        game = new GameEngine(this);

        if (getList().size() > 0) {
            game.nextPicture();
            updatePicture();
            updateScore();
        }

    }

    public void sendAnswer(View view) {
        EditText editText = (EditText) findViewById(R.id.edit_message);
        String message = editText.getText().toString();
        editText.setText("");

        game.checkAnswer(message);
        game.nextPicture();

        updatePicture();
        updateScore();
    }

    public void updatePicture() {
        final ImageView imgview = (ImageView) findViewById(R.id.imageView);
        imgview.setImageBitmap(game.getBitmap());
    }

    public void updateScore() {
        String scoreAndAttempts = game.getScore() + "/" + game.getAttempts();

        TextView score = (TextView) findViewById(R.id.score);
        score.setText(scoreAndAttempts);
    }
}
