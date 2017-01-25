package com.example.tony.name_app.Activities;

import android.os.SystemClock;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.tony.name_app.ImageAdapter;
import com.example.tony.name_app.Person;
import com.example.tony.name_app.R;

import java.util.ArrayList;

import static com.example.tony.name_app.LocalDatabase.getList;


public class Gallery extends AppCompatActivity {


    public ArrayList<Person> persons = new ArrayList<Person>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        setTitle("Gallery");

        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        persons = getList();

        GridView grid = (GridView) findViewById(R.id.gridView);
        grid.setAdapter(new ImageAdapter(this, R.layout.single_image, persons));

        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            long mLastClickTime = 0;

            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {

                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000) {
                    return;
                }

                mLastClickTime = SystemClock.elapsedRealtime();

                Toast.makeText(Gallery.this, "" +  persons.get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}
