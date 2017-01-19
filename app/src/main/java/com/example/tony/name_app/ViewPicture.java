package com.example.tony.name_app;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import static com.example.tony.name_app.addPerson.persons;

public class ViewPicture extends AppCompatActivity {
    ImageView view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_picture);


        this.view = (ImageView) this.findViewById(R.id.test);

        Bitmap photo = persons.get(0);
        view.setImageBitmap(photo);
    }
}
