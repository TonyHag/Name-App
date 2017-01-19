package com.example.tony.name_app;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    ArrayList<Person> persons = new ArrayList<Person>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
     /*   Person person1 = new Person("@drawable/tawny", "Tony", 1);
        Person person2 = new Person("@drawable/nawty", "Naty", 2);
        persons.add(person1);
        persons.add(person2);*/
    }

    public void startListOfNames(View view) {
        Intent intent = new Intent(this, ListOfNames.class);

        Person person = new Person();
        person.setName("Nataniel Pedersen");
        person.setImgURI("//");
        person.setIndex(0);

        Person person2 = new Person();
        person2.setName("Frank Leif");
        person2.setImgURI("//");
        person2.setIndex(1);

        persons.add(person);
        persons.add(person2);

        intent.putParcelableArrayListExtra("persons", persons);

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
