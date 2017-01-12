package com.example.tony.name_app;

        import android.hardware.camera2.*;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.widget.FrameLayout;

public class CameraActivity extends AppCompatActivity {

    private CameraDevice mCamera;
    private CameraPreview mPreview;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        // Create an instance of Camera
        mCamera = getCameraInstance();

        // Create our Preview view and set it as the content of our activity.
        mPreview = new CameraPreview(this, mCamera);
        FrameLayout preview = (FrameLayout) findViewById(R.id.camera_preview);
        preview.addView(mPreview);
    }
}