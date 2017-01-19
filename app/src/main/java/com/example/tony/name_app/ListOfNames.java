package com.example.tony.name_app;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import com.example.tony.name_app.Person;

import static com.example.tony.name_app.CatList.findUriFromName;
import static com.example.tony.name_app.CatList.getList;
import static com.example.tony.name_app.CatList.initialize;


public class ListOfNames extends AppCompatActivity {

    public ArrayList<Person> persons = new ArrayList<Person>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_names);

        persons = getList();
        // getIntent().getParcelableArrayListExtra("persons");

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
                String itemValue = (String) list.getItemAtPosition(position);

                Uri uri = findUriFromName(itemValue);

                showImage(uri);
            }
        });
    }

    public void showImage(Uri imageUri) {
        Dialog builder = new Dialog(this);
        builder.requestWindowFeature(Window.FEATURE_NO_TITLE);
        builder.getWindow().setBackgroundDrawable(
                new ColorDrawable(android.graphics.Color.TRANSPARENT)
        );
        builder.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialogInterface) {
                // nothing
            }
        });
        ImageView imageView = new ImageView(this);
        imageView.setImageURI(imageUri);

        builder.addContentView(imageView, new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT)
        );
        builder.show();
    }
}
