package com.example.tony.name_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.ArrayList;
import com.example.tony.name_app.Person;


public class ListOfNames extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_names);

        //MainActivity.persons.add(1, new Person("#", "Nataniel Pedersen", 1));
    }
}
