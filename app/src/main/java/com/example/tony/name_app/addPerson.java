package com.example.tony.name_app;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class addPerson extends AppCompatActivity {
    private static final int CAMERA_REQUEST = 1888;
    private ImageView imageView;
    TextView textTargetUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_person);
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

    public void add(){
        String img ="";
        String name ="";
        int index = 0;
        //Person person = new Person(img, name, index);
    }

    static final int REQUEST_IMAGE_CAPTURE = 1;


    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        textTargetUri = (TextView)findViewById(R.id.targeturi);
        if (requestCode == CAMERA_REQUEST && resultCode == Activity.RESULT_OK) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");

            imageView.setImageBitmap(photo);
            MediaStore.Images.Media.insertImage(getContentResolver(), photo, "Pussyman" , "Tony i sitt habitat");
            //Henter filepath og viser under bilde i view
            Uri targetUri = data.getData();
            if(targetUri != null) {
                textTargetUri.setText(targetUri.toString());
            }
        }
    }


}
