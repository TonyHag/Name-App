package com.example.tony.name_app.Activities;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.tony.name_app.R;

import static com.example.tony.name_app.LocalDatabase.addPersonToList;

public class AddOwner extends AppCompatActivity {
    private static final int CAMERA_REQUEST = 1888;

    private EditText ownerName;
    private ImageView ownerProfilePreview;
    private Bitmap ownerProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_owner);

        setTitle("Register owner");
        ownerProfilePreview = (ImageView) this.findViewById(R.id.bilde);

        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
    }

    public void addOwner(View view) {
        ownerName = (EditText)findViewById(R.id.name_input);
        Log.d("name", ownerName.getText().toString());

        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor edit = pref.edit();
        edit.putString("profile_name", ownerName.getText().toString());
        edit.commit();

        addPersonToList(ownerName.getText().toString(), ownerProfile);
        finish();
    }

    public void takePicture(View view) {
        Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(cameraIntent, CAMERA_REQUEST);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAMERA_REQUEST && resultCode == Activity.RESULT_OK) {
            ownerProfile = (Bitmap) data.getExtras().get("data");
            ownerProfilePreview.setImageBitmap(ownerProfile);
        }
    }
}
