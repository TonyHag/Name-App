package com.example.tony.name_app.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.tony.name_app.LocalDatabase;
import com.example.tony.name_app.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Name App");

        LocalDatabase.initialize(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        View viewview = findViewById(R.id.activity_add_person);

        if (id == R.id.button_goto_add_person) {
            startaddPerson(viewview);
        }
        return super.onOptionsItemSelected(item);
    }

    public void startListOfNames(View view) {
        Intent intent = new Intent(this, ListOfNames.class);
        startActivity(intent);
    }

    public void startQuiz(View view){
        Intent intent = new Intent(this, LearningMode.class);
        startActivity(intent);
    }

    public void startaddPerson(View view){
        Intent intent = new Intent(this, AddPerson.class);
        startActivity(intent);
    }

    public void gotoGallery(View view){
        Intent intent = new Intent(this, Gallery.class);
        startActivity(intent);
    }

}
