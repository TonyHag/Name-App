package com.example.tony.name_app;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.Gravity;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class GameEngine {
    Context context;

    Integer score;
    Integer attempts;

    Integer randomNumber;

    Person person;
    String correctName;
    Bitmap bitmap;
    int previousNumber;

    final ArrayList<Person> list;

    public GameEngine(Context context) {
        this.score = 0;
        this.attempts = 0;
        this.context = context;

        list = LocalDatabase.getList();
    }

    public void checkAnswer(String name) {
        if (correctName.toLowerCase().equals(name.toLowerCase())) {
            attempts++;
            score++;

            Toast toast = Toast.makeText(this.context, R.string.right_answer, Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
            toast.show();
        } else {
            Toast toast = Toast.makeText(this.context, R.string.wrong_answer, Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
            toast.show();
            attempts++;
        }
    }

    public void nextPicture() {

        randomNumber = generateRandom();

        person = list.get(randomNumber);
        correctName = person.getName();
        bitmap = person.getBitmap();
    }

    public Integer getAttempts() {
        return attempts;
    }

    public Integer getScore() {
        return score;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }



private int generateRandom() {
    Random r = new Random(System.currentTimeMillis());
    while (true) {
        int randomNumber = r.nextInt(list.size());
        if (randomNumber != previousNumber) {
            previousNumber = randomNumber;
            return randomNumber;
        }
    }
}
}