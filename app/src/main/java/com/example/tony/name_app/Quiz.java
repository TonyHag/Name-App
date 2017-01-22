package com.example.tony.name_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Quiz extends AppCompatActivity {
    LearningModeController game;
    
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        
        game = new LearningModeController(this);
        game.nextPicture();
        updatePicture();
        updateScore();
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
        //imgview.setImageURI(game.imgUri);
        imgview.setImageBitmap(game.bitmap);
    }

    public void updateScore() {
        String scoreAndAttempts = game.score + "/" + game.attempts;

        TextView score = (TextView) findViewById(R.id.score);
        score.setText(scoreAndAttempts);
    }
}
