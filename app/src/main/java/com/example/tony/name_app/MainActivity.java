package com.example.tony.name_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void startQuiz(View view){
        Intent intent = new Intent(this, Quiz.class);
        startActivity(intent);
    }
    public void startaddPerson(View view){
        Intent intent = new Intent(this, addPerson.class);
        startActivity(intent);
    }
}
