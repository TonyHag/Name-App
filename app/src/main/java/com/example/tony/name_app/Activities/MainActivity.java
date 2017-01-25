package com.example.tony.name_app.Activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.tony.name_app.LocalDatabase;
import com.example.tony.name_app.R;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Name App");

        LocalDatabase.initialize(this);

        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = pref.edit();

        //editor.clear();
        //editor.commit();

        if (!pref.contains("profile_name")) {
            Intent intent = new Intent(this, AddOwner.class);
            startActivity(intent);
        } else {
            String name = pref.getString("profile_name", "DEFAULT");
            Toast toast = Toast.makeText(this, "Welcome back " + name + "!", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        View viewAddPerson = findViewById(R.id.activity_add_person);

        if (id == R.id.add) {
            startAddPerson(viewAddPerson);
        }

        return super.onOptionsItemSelected(item);
    }

    public void startListOfNames(View view) {
        Intent intent = new Intent(this, ListOfNames.class);
        startActivity(intent);
    }

    public void startLearningMode(View view){
        Intent intent = new Intent(this, LearningMode.class);
        startActivity(intent);
    }

    public void startAddPerson(View view){
        Intent intent = new Intent(this, AddPerson.class);
        startActivity(intent);
    }

    public void startGallery(View view){
        Intent intent = new Intent(this, Gallery.class);
        startActivity(intent);
    }

}
