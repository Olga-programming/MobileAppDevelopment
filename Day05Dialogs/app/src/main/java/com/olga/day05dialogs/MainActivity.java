package com.olga.day05dialogs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnDialog, btnToasts, btnInternet, btnAsync, btnSpinner, btnListView, btnFile, btnDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();
    }

    private void initialize() {
        btnDialog = findViewById(R.id.btnDialog);
        btnDialog.setOnClickListener(this);

        btnToasts = findViewById(R.id.btnToasts);
        btnToasts.setOnClickListener(this);

        btnInternet = findViewById(R.id.btnInternet);
        btnInternet.setOnClickListener(this);

        btnAsync = findViewById(R.id.btnAsync);
        btnAsync.setOnClickListener(this);

        btnSpinner = findViewById(R.id.btnSpinner);
        btnSpinner.setOnClickListener(this);

        btnListView = findViewById(R.id.btnListView);
        btnListView.setOnClickListener(this);

        btnFile = findViewById(R.id.btnFile);
        btnFile.setOnClickListener(this);

        btnDB = findViewById(R.id.btnDB);
        btnDB.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnDialog:
                showdialog();
                break;
            case R.id.btnToasts:
                toasts();
                break;
            case R.id.btnInternet:
                internet();
                break;
            case R.id.btnAsync:
                async();
                break;
            case R.id.btnSpinner:
                spiner();
                break;
            case R.id.btnListView:
                listview();
                break;
            case R.id.btnFile:
                toast();
                break;
            case R.id.btnDB:
                toast();
                break;
        }
    }

    private void showdialog() {
        Intent intent = new Intent(this, DialogActivity.class);
        startActivity(intent);
    }

    private void toasts() {

    }

    private void internet() {

    }

    private void async() {

    }

    private void spiner() {
        Intent intent = new Intent(this, SpinnerActivity.class);
        startActivity(intent);
    }

    private void listview() {

    }

    private void toast() {

    }
}
