package com.olga.day03activitypractice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Temperature_activity extends AppCompatActivity {
    EditText textTempCel;
    TextView textTempFar;
    Button btnconvert, btnreturn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature_activity);

        initialize();

    }

    private void initialize(){
        textTempCel = findViewById(R.id.textTempCel);
        textTempFar = findViewById(R.id.textTempFar);
        btnconvert = findViewById(R.id.btnTempConvert);
        btnconvert = findViewById(R.id.btnTempReturn);
    }


    public void tempOperate(View view) {
        int tempBtn = view.getId();

        switch (tempBtn){
            case R.id.btnTempConvert:
                tempConvert();
                break;
            case R.id.btnTempReturn:
                tempReturn();
                break;
        }
    }

    private void tempConvert() {
        float celcius = Float.valueOf(textTempCel.getText().toString());
        double result = ((9.0/5.0)*celcius)+32;
        textTempFar.setText(String.valueOf(result));
    }

    private void tempReturn() {
        finish();
    }
}
