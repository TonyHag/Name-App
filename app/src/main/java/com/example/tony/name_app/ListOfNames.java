package com.example.tony.name_app;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import com.example.tony.name_app.Person;


public class ListOfNames extends AppCompatActivity {

    public ArrayList<Person> persons = new ArrayList<Person>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_names);

        persons = getIntent().getParcelableArrayListExtra("persons");

        for (Person person : persons) {
            System.out.println(person.getName());
        }

        final ListView list = (ListView)findViewById(R.id.listView);

        ArrayList<String> names = new ArrayList<String>();

        for (Person person : persons) {
            names.add(person.getName());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                names
        );

        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int itemPosition     = position;
                String  itemValue    = (String) list.getItemAtPosition(position);

                new AlertDialog.Builder(ListOfNames.this)
                        .setTitle("Person")
                        .setMessage(itemValue)
                        .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // continue with delete
                            }
                        })
                        .show();
            }
        });

    }
}
