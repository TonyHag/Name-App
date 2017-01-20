package com.example.tony.name_app;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import static com.example.tony.name_app.addPerson.persons;

public class Gallery extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        ImageView img1 = (ImageView) this.findViewById(R.id.img1);
        ImageView img2 = (ImageView) this.findViewById(R.id.img2);
        ImageView img3 = (ImageView) this.findViewById(R.id.img3);
        ImageView img4 = (ImageView) this.findViewById(R.id.img4);
        ImageView img5 = (ImageView) this.findViewById(R.id.img5);
        if(!persons.isEmpty()) {
            Bitmap photo1 = persons.get(0);
            img1.setImageBitmap(photo1);
        }
        if(persons.size() >= 2) {
            Bitmap photo2 = persons.get(1);
            img2.setImageBitmap(photo2);
        }
        if(persons.size() >= 3) {
            Bitmap photo3 = persons.get(2);
            img3.setImageBitmap(photo3);
        }
        if(persons.size() >= 4) {
            Bitmap photo4 = persons.get(3);
            img4.setImageBitmap(photo4);
        }
        if(persons.size() >= 5) {
            Bitmap photo5 = persons.get(4);
            img5.setImageBitmap(photo5);
        }
    }
    public void gotoPicture(View view){
        Intent intent = new Intent(this, ViewPicture.class);
        switch (view.getId()) {
            case R.id.img1:
                intent.putExtra("index", 0);
                break;
            case R.id.img2:
                intent.putExtra("index", 1);
                break;
            case R.id.img3:
                intent.putExtra("index", 2);
                break;
            case R.id.img4:
                intent.putExtra("index", 3);
                break;
            case R.id.img5:
                intent.putExtra("index", 4);
                break;

        }
        startActivity(intent);

    }
}
