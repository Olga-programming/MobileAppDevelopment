package com.olga.day05dialogs.toast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import com.olga.day05dialogs.R;

public class ToastActivity extends AppCompatActivity {

    Button btnToast1, btnToast2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);

        initialize();

    }

    private void initialize() {
        btnToast1 = findViewById(R.id.btnToast1);
        btnToast2 = findViewById(R.id.btnToast2);
    }


}
