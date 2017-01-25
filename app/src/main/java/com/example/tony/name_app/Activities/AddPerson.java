package com.example.tony.name_app.Activities;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tony.name_app.R;

import static com.example.tony.name_app.LocalDatabase.addPersonToList;

public class AddPerson extends AppCompatActivity {
    private static final int CAMERA_REQUEST = 1888;
    private ImageView imageView;
    TextView textTargetUri;
    Bitmap photo;

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
    }

    public void add(View view) {
        EditText mEdit = (EditText)findViewById(R.id.name_input);
        String name = mEdit.getText().toString();
        addPersonToList(name, photo);
        finish();
    }



    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        textTargetUri = (TextView)findViewById(R.id.targeturi);
        if (requestCode == CAMERA_REQUEST && resultCode == Activity.RESULT_OK) {
            photo = (Bitmap) data.getExtras().get("data");

            imageView.setImageBitmap(photo);
        }
    }




}
