package com.olga.day03activitypractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText edittext;
    Button temperature;
    Button metric;
    Button finish;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();
    }

    private void initialize(){
        edittext = findViewById(R.id.textEdit);
        temperature = findViewById(R.id.btnTemperature);
        metric = findViewById(R.id.btnMetric);
        finish = findViewById(R.id.btnFinish);
    }

   public void operate(View view){
        int btn = view.getId();

        switch (btn){
            case R.id.btnTemperature:
                temperatureConvertation();
                break;
            case R.id.btnMetric:
                metricConveesation();
                break;
            case R.id.btnFinish:
                finish();
                break;
        }
   }

    private void temperatureConvertation() {
            Intent tempIntent = new Intent (this, Temperature_activity.class);
        startActivity(tempIntent);

    }

    private void metricConveesation() {
        String lastname = edittext.getText().toString();
        Intent mertIntent = new Intent (this, Activity_metric.class);
        mertIntent.putExtra("lastName", lastname);
        startActivity(mertIntent);
    }


}
