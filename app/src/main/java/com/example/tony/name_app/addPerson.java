package com.example.tony.name_app;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.prefs.Preferences;


import static android.R.attr.content;
import static com.example.tony.name_app.CatList.addPersonToList;

public class addPerson extends AppCompatActivity {
    private static final int CAMERA_REQUEST = 1888;
    private ImageView imageView;
    TextView textTargetUri;
    Bitmap photo;

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

    public void add(View view) {
        EditText mEdit = (EditText)findViewById(R.id.name_input);
        String name = mEdit.getText().toString();
        //Person person = new Person(name, null, photo);
        addPersonToList(name, photo);
        finish();
    }

    static final int REQUEST_IMAGE_CAPTURE = 1;


    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        textTargetUri = (TextView)findViewById(R.id.targeturi);
        if (requestCode == CAMERA_REQUEST && resultCode == Activity.RESULT_OK) {
            photo = (Bitmap) data.getExtras().get("data");

            imageView.setImageBitmap(photo);


            //lager metode for å lagre til internal storage og legge filepath til shared preferences
           String path = saveToInternalStorage(photo);
           Log.d("MyActivity",path);

            //Might be bollshit below this point
            SharedPreferences shre = PreferenceManager.getDefaultSharedPreferences(this);
            SharedPreferences.Editor edit=shre.edit();
            edit.putString(path,"Nils");
            edit.commit();
            String n =  Boolean.toString(shre.contains(path));

            Log.d("PISSINASS", n );




        }
    }

    private String saveToInternalStorage(Bitmap bitmapImage){
        ContextWrapper cw = new ContextWrapper(getApplicationContext());
        // path to /data/data/yourapp/app_data/imageDir
        File directory = cw.getDir("imageDir", Context.MODE_PRIVATE);
        // Create imageDir
        File mypath=new File(directory,"profile.jpg");

        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(mypath);
            // Use the compress method on the BitMap object to write image to the OutputStream
            bitmapImage.compress(Bitmap.CompressFormat.PNG, 100, fos);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return directory.getAbsolutePath();
    }


}
