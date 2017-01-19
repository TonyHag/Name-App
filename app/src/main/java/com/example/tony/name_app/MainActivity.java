package com.example.tony.name_app;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

import static com.example.tony.name_app.CatList.initialize;


public class MainActivity extends AppCompatActivity {
    ArrayList<Person> persons = new ArrayList<Person>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize(this);
    }

    public void startListOfNames(View view) {
        Intent intent = new Intent(this, ListOfNames.class);

        //intent.putParcelableArrayListExtra("persons", persons);

        startActivity(intent);
    }

    public void startQuiz(View view){
        Intent intent = new Intent(this, Quiz.class);
        startActivity(intent);
    }

    public void startaddPerson(View view){
        Intent intent = new Intent(this, addPerson.class);
        startActivity(intent);
    }

    public void gotoGallery(View view){
        Intent intent = new Intent(this, Gallery.class);
        startActivity(intent);
    }

}
