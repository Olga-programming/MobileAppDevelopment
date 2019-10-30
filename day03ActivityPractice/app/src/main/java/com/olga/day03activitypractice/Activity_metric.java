package com.olga.day03activitypractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Activity_metric extends AppCompatActivity {

    TextView textMetrLast, textMetrCentimeter, textMetrKilometer;
    EditText textMetricMeter;
    Button btnconvert, btnreturn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_metric);
        initialize();
        metrGetIntent();
    }



    private void initialize(){
        textMetrLast = findViewById(R.id.textMetrLast);
        textMetrCentimeter = findViewById(R.id.textMetrCentimeter);
        textMetrKilometer = findViewById(R.id.textMetrKilometer);
        textMetricMeter = findViewById(R.id.textMetricMeter);
        btnconvert = findViewById(R.id.btnMetrConvert);
        btnreturn = findViewById(R.id.btnMetrReturn);
    }

    private void metrGetIntent() {
        Intent intent  = getIntent();
        String lastname = intent.getStringExtra("lastName");
        textMetrLast.setText(lastname);
    }

    public void metrOperate(View view) {
        int metrBtn = view.getId();

        switch (metrBtn){
            case R.id.btnMetrConvert:
                metrConvert();
                break;
            case R.id.btnMetrReturn:
                metrReturn();
                break;
        }
    }

    private void metrConvert() {
        double centimetr =Double.valueOf(textMetricMeter.getText().toString()) * 100;
        textMetrCentimeter.setText(String.valueOf(centimetr));

        double kilometer =Double.valueOf(textMetricMeter.getText().toString()) / 1000;
        textMetrKilometer.setText(String.valueOf(kilometer));
    }


    private void metrReturn() {
        finish();
    }

}
