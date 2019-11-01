package com.olga.day06broadcasting;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int PERM_REQ_CODE = 1234;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP_MR1){
            checkPermissions();
        }
    }

    private void checkPermissions() {
        if (!hasPermissionForCallEvent()){
            String[] perm = new String[]{
                    Manifest.permission.READ_PHONE_STATE,
                    Manifest.permission.PROCESS_OUTGOING_CALLS};
            ActivityCompat.requestPermissions(this, perm, PERM_REQ_CODE);
        }
    }

    private boolean hasPermissionForCallEvent() {
        return ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE)
                == PackageManager.PERMISSION_GRANTED &&

                ActivityCompat.checkSelfPermission(this, Manifest.permission.PROCESS_OUTGOING_CALLS)
                        == PackageManager.PERMISSION_GRANTED;

    }

    @Override
    public void onRequestPermissionsResult(
            int requestCode,
            @NonNull String[] permissions,
            @NonNull int[] grantResults) {
       if(requestCode == PERM_REQ_CODE){
           if(grantResults[0] == PackageManager.PERMISSION_GRANTED && grantResults[1] == PackageManager.PERMISSION_GRANTED){
               Toast.makeText(this,"Permission granted", Toast.LENGTH_LONG).show();
           } else{
               Toast.makeText(this,"Permission denied", Toast.LENGTH_LONG).show();
           }
       }
    }
}
