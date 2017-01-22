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
        //Hentar inn svaret frå brukaren og nullar ut tekstfeltet
        EditText editText = (EditText) findViewById(R.id.edit_message);
        String message = editText.getText().toString();
        editText.setText("");

        //Brukar spel-klassen til å sjekke svar og lage klart nytt bilete.
        game.checkAnswer(message);
        game.nextPicture();

        //Oppdaterar view for bilete og tekst.
        updatePicture();
        updateScore();
    }

    //Metode som legg inn bilete i imageView
    public void updatePicture(){
        final ImageView imgview = (ImageView) findViewById(R.id.imageView);
        imgview.setImageURI(game.imgUri);
    }

    //Metode som oppdaterar tekstfelt med score og antall forsøk.
    public void updateScore(){

        String numCorrect = "Score: " + game.score;
        String numAttempts = "Attempts: " + game.attempts;

        TextView score = (TextView) findViewById(R.id.score);
        score.setText(numCorrect);

        TextView attempts = (TextView) findViewById(R.id.attempts);
        attempts.setText(numAttempts);

    }
}
