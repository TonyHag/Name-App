package com.example.tony.name_app;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import static com.example.tony.name_app.addPerson.names;
import static com.example.tony.name_app.addPerson.persons;

public class ViewPicture extends AppCompatActivity {
    ImageView view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_picture);
        int index = getIntent().getIntExtra("index", 0);

        this.view = (ImageView) this.findViewById(R.id.test);

        Bitmap photo = persons.get(index);
        view.setImageBitmap(photo);
        TextView name = (TextView) this.findViewById(R.id.name_img);
        name.setText(names.get(index).toCharArray(), 0, names.get(index).length());
    }
}
