package com.example.tony.name_app;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import static com.example.tony.name_app.CatList.getList;


public class ViewPicture extends AppCompatActivity {
    public ArrayList<Person> persons = new ArrayList<Person>();
    ImageView view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_picture);
        int index = getIntent().getIntExtra("index", 0);
        persons = getList();
        this.view = (ImageView) this.findViewById(R.id.test);

        Bitmap photo = persons.get(index).getBitmap();
        view.setImageBitmap(photo);
        TextView name = (TextView) this.findViewById(R.id.name_img);
        name.setText(persons.get(index).getName().toCharArray(), 0, persons.get(index).getName().length());
    }
}
