package com.olga.day03returnresulttomain;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActivityTest2 extends AppCompatActivity implements View.OnClickListener {

    Button test2Ok, test2Cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test2);
        initialize();
    }

    private void initialize(){
        test2Ok = findViewById(R.id.btnTest2Ok);
        test2Ok.setOnClickListener(this);

        test2Cancel = findViewById(R.id.btnTest2Cancel);
        test2Cancel.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btnTest2Ok:
                test2_OkMethod();
                break;
            case R.id.btnTest2Cancel:
                test2_CancelMethod();
                break;
        }
    }

    private void test2_CancelMethod() {
        String strResult = "Operation canceled";

        //------------------------------------ Create an intent
        Intent intent = new Intent();
        intent.putExtra("cancel_tag", strResult);

        //------------------------------------ Set Result for MainActivity
        setResult(RESULT_CANCELED, intent);
        finish();
    }

    private void test2_OkMethod() {
        String strResult = "Ok result from test2";

        //------------------------------------ Create an intent and putExtra result string
        Intent intent = new Intent();
        intent.putExtra("return_result_from_test2", strResult);

        //------------------------------------ Set Result for MainActivity
        setResult(RESULT_OK, intent);
        finish();
    }
}
