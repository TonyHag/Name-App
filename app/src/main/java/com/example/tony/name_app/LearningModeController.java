package com.example.tony.name_app;

import android.content.Context;
import android.net.Uri;

import java.util.ArrayList;
import java.util.Random;

import static com.example.tony.name_app.CatList.getList;

/**
 * Created by nataniel on 19.01.2017.
 */

public class LearningModeController {
    Context context;
    Integer score;
    Integer attempts;
    Integer randomNumber;
    Person person;
    String correctName;
    Uri imgUri;

    final ArrayList<Person> list;

    public LearningModeController(Context context) {
        this.context = context;
        this.score = 0;
        this.attempts = 0;

        list = getList();
    }

    public void nextPicture() {
        Random r = new Random(System.currentTimeMillis());
        randomNumber = r.nextInt(list.size());

        person = list.get(randomNumber);
        correctName = person.getName();
        imgUri = person.getImgURI();
    }

    public void checkAnswer(String name) {
        if (correctName.toLowerCase().equals(name.toLowerCase())) {
            attempts++;
            score++;
        } else {
            attempts++;
        }
    }
}
