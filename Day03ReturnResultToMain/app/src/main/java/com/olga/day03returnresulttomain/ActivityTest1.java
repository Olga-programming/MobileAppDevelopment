package com.olga.day03returnresulttomain;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import static java.lang.String.valueOf;

public class ActivityTest1 extends AppCompatActivity implements View.OnClickListener, TextWatcher {
    TextView test1TextView;
    EditText textTest2Answer;
    Button btntest2Generate, btntest2Validate, btntest2Cancel;

    int rightResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test1);
        initialize();
    }

    private void initialize() {
        textTest2Answer = findViewById(R.id.textTest1Answer);
        test1TextView =  findViewById(R.id.test1TextView);

        btntest2Generate = findViewById(R.id.btnTest1Generate);
        btntest2Generate.setOnClickListener(this);

        btntest2Validate = findViewById(R.id.btnTest1Validate);
        btntest2Validate.setOnClickListener(this);

        btntest2Cancel = findViewById(R.id.btnTest1Cancel);
        btntest2Cancel.setOnClickListener(this);

        //------------------------------------------ Validation
        textTest2Answer.addTextChangedListener(this);
        btntest2Validate.setEnabled(false);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.btnTest1Generate:
                goGenerate();
                break;

            case R.id.btnTest1Validate:
                goValidate();
                break;

            case R.id.btnTest1Cancel:
                goCancel();
                break;
        }
    }

    private void goCancel() {
        String strResult = "Operation canceled";

        //------------------------------------ Create an intent
        Intent intent = new Intent();
        intent.putExtra("cancel_tag", strResult);

        //------------------------------------ Set Result for MainActivity
        setResult(RESULT_CANCELED, intent);
        finish();
    }

    private void goGenerate() {
        Random random = new Random();
        int operand1 = random.nextInt(10);
        int operand2 = random.nextInt(10);
        rightResult = operand1 + operand2;

        String operation = String.valueOf(operand1) + "+" + String.valueOf(operand2) + "= ?";

        test1TextView.setText(operation);
    }

    private void goValidate() {
        int integerUserAnswer = Integer.valueOf(textTest2Answer.getText().toString());

        String strResult;

        if (integerUserAnswer == rightResult) {
            strResult = "Right Answer!";
        } else {
            strResult = "Wrong Answer!";
        }

        //------------------------------------ Create an intent and putExtra result string
        Intent intent = new Intent();
        intent.putExtra("return_result_tag", strResult);

        //------------------------------------ Set Result for MainActivity
        setResult(RESULT_OK, intent);
        finish();
    }

    // TextWatcher Interface
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
    }

    @Override
    public void afterTextChanged(Editable s) {

        try {
            int nb = Integer.valueOf(textTest2Answer.getText().toString());
            if (nb > 18) {
                Toast.makeText(this, "The total should be <= 18", Toast.LENGTH_SHORT).show();
                btntest2Validate.setEnabled(false);
            } else
                btntest2Validate.setEnabled(true);
        } catch (Exception e) {
            Toast.makeText(this, "Enter a number data type", Toast.LENGTH_SHORT).show();
        }
    }
}
