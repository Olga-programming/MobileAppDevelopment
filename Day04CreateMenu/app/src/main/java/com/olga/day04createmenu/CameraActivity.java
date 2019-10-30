package com.olga.day04createmenu;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;

public class CameraActivity extends AppCompatActivity {
    private static final int REQUEST_CODE_CAMERA = 1; // 1-65535

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
    }

    public void takePhoto(View view){
        Intent photoIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        if(photoIntent.resolveActivity(getPackageManager()) != null){
            startActivityForResult(photoIntent,REQUEST_CODE_CAMERA );
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_CODE_CAMERA){
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            ImageView imageViewCamera = findViewById(R.id.imageViewCamera);
            imageViewCamera.setImageBitmap(bitmap);
        }
    }
}
