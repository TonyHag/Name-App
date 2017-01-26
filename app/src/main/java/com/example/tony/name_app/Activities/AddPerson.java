package com.example.tony.name_app.Activities;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tony.name_app.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;


import static com.example.tony.name_app.LocalDatabase.addPersonToList;

public class AddPerson extends AppCompatActivity {
    private static final int CAMERA_REQUEST = 1888;
    private ImageView imageView;
    TextView textTargetUri;
    Bitmap photo;
    private static final int SELECT_PICTURE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_person);

        setTitle("Add Person");

        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

       this.imageView = (ImageView) this.findViewById(R.id.bilde);
        Button photoButton = (Button) this.findViewById(R.id.button_add);
        photoButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_REQUEST);
            }
        });
        findViewById(R.id.button_select).setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent,"Select Picture"), SELECT_PICTURE);
            }
        });

    }

    public void add(View view) {
        EditText mEdit = (EditText)findViewById(R.id.name_input);
        String name = mEdit.getText().toString();
        addPersonToList(name, photo);
        finish();
    }



    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        textTargetUri = (TextView)findViewById(R.id.targeturi);
        if(resultCode != RESULT_CANCELED){

            if(requestCode == SELECT_PICTURE){
                try {
                    Uri selectedimg = data.getData();
                    photo = MediaStore.Images.Media.getBitmap(this.getContentResolver(), selectedimg);
                    imageView.setImageBitmap(photo);
                }catch (IOException exception){

                }
            }

            if (requestCode == CAMERA_REQUEST ) {
                photo = (Bitmap) data.getExtras().get("data");

                imageView.setImageBitmap(photo);
            }
        }
    }





}
