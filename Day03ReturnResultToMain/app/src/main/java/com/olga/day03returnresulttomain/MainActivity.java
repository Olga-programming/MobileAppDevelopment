package com.olga.day03returnresulttomain;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    final static int REQUEST_CODE1 = 1;
    final static int REQUEST_CODE2 = 2;

    Button btnTest1, btnTest2;
    TextView textMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }

    private void initialize(){

        textMain = findViewById(R.id.mainTextView);

        btnTest1 = findViewById(R.id.mainTest1);
        btnTest1.setOnClickListener(this);

        btnTest2 = findViewById(R.id.mainTest2);
        btnTest2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view){
        switch (view.getId()){
            case R.id.mainTest1:
                gotoTest1();
                break;

            case R.id.mainTest2:
                gotoTest2();
                break;
        }
    }

    private void gotoTest1() {
        Intent intent = new Intent(this, ActivityTest1.class);
        startActivityForResult(intent, REQUEST_CODE1);
    }

    private void gotoTest2() {
        Intent intent = new Intent(this, ActivityTest2.class);
        startActivityForResult(intent, REQUEST_CODE2);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE1) {
            String receivedData = (String) data.getStringExtra("return_result_tag");

            if (resultCode == RESULT_OK)
                textMain.setText(receivedData);
            else
                textMain.setText("Canceled");
        }

        if (requestCode == REQUEST_CODE2) {
            String receivedData = (String) data.getStringExtra("return_result_from_test2");

            if (resultCode == RESULT_OK)
                textMain.setText(receivedData);
            else
                textMain.setText("Canceled from test2");
        }
    }
}
