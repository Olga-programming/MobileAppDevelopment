package com.olga.day05dialogs;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class DialogActivity extends AppCompatActivity implements View.OnClickListener, DialogInterface.OnClickListener {

    Button btnDialogAlertDlgBuild1, btnDialogAlertDlgBuild2, btnDialogAlertDlgBuild3,
            btnDialogAlertDlgBuild4, btnDialogProgressDlg, btnDialogCustomDlg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);

        initialize();
    }

    private void initialize() {
        btnDialogAlertDlgBuild1 = findViewById(R.id.btnDialogAlertDlgBuild1);
        btnDialogAlertDlgBuild1.setOnClickListener(this);

        btnDialogAlertDlgBuild2 = findViewById(R.id.btnDialogAlertDlgBuild2);
        btnDialogAlertDlgBuild2.setOnClickListener(this);

        btnDialogAlertDlgBuild3 = findViewById(R.id.btnDialogAlertDlgBuild3);
        btnDialogAlertDlgBuild3.setOnClickListener(this);

        btnDialogAlertDlgBuild4 = findViewById(R.id.btnDialogAlertDlgBuild4);
        btnDialogAlertDlgBuild4.setOnClickListener(this);

        btnDialogProgressDlg = findViewById(R.id.btnDialogProgressDlg);
        btnDialogProgressDlg.setOnClickListener(this);

        btnDialogCustomDlg = findViewById(R.id.btnDialogCustomDlg);
        btnDialogCustomDlg.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnDialogAlertDlgBuild1:
                dialogAlertDlgBuild1();
                break;
            case R.id.btnDialogAlertDlgBuild2:
                dialogAlertDlgBuild2();
                break;
            case R.id.btnDialogAlertDlgBuild3:
                dialogAlertDlgBuild3();
                break;
            case R.id.btnDialogAlertDlgBuild4:
                dialogAlertDlgBuild4();
                break;
            case R.id.btnDialogProgressDlg:
                dialogProgressDlg();
                break;
            case R.id.btnDialogCustomDlg:
                dialogCustomDlg();
                break;

        }
    }

    private void dialogCustomDlg() {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.activity_dialog);

    }

    private void dialogProgressDlg() {
        final AlertDialog.Builder progressDialog = new AlertDialog.Builder(this);
        progressDialog.setTitle("progress dialog example");
        progressDialog.setMessage("Please wait");
        //progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        //progressDialog.setIndeterminate(true);
        progressDialog.show();

    }


    private void dialogAlertDlgBuild4() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("")
                .setCancelable(false)
                .setMultiChoiceItems(new String[]{"item0", "item1", "item2", "item3", "item4", "item5"}, //milti choise
                        new boolean[]{false, true, false, true, true, false}, //define default
                        new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                                Toast.makeText(DialogActivity.this ,"i = " + i + " B :", Toast.LENGTH_SHORT).show();
                            }
                        })
                .setPositiveButton("Ok", null);

        builder.show();
    }

    private void dialogAlertDlgBuild3() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //type 3
        builder.setTitle("Question? ")
                .setCancelable(false)
                .setSingleChoiceItems(new String[]{"A", "B", "C", "D"}, //singlr choice
                        0, //-1 for no default selection
                        new DialogInterface.OnClickListener(){

                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(DialogActivity.this, "i = " + i, Toast.LENGTH_SHORT).show();
                            }
                        })
                .setPositiveButton("Ok", null);
        builder.show();
     }

    private void dialogAlertDlgBuild2() {
        final AlertDialog.Builder builder  = new AlertDialog.Builder(this);
        //type 2
        builder.setTitle("Alert/Dialog/ajust a question for demo")
                .setMessage("Dou you want to delete this file?")
                .setCancelable(false)
                .setIcon(android.R.drawable.ic_dialog_info)
                //we just define event listener for yes buttons
                //but it can be difine for no an camcel
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                         }

                })
                .setNegativeButton("No", null)
                .setNeutralButton("Cncel", null);
        builder.show();
    }

    private void dialogAlertDlgBuild1() {
        AlertDialog.Builder alertDialogBiulder = new AlertDialog.Builder(this);

        alertDialogBiulder.setTitle("This is my title");

        //second arguemnt in below method is a reference to event listener
        alertDialogBiulder.setPositiveButton("Yes", (DialogInterface.OnClickListener) this);
        alertDialogBiulder.setNegativeButton("No", (DialogInterface.OnClickListener) this);
        alertDialogBiulder.setNeutralButton("Neutral", (DialogInterface.OnClickListener) this);

        AlertDialog alertDialog = alertDialogBiulder.create();
        alertDialog.show();

    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        switch (which){
            case DialogInterface.BUTTON_POSITIVE:
                Toast.makeText(DialogActivity.this, "id = " + which, Toast.LENGTH_SHORT).show();
                break;
            case DialogInterface.BUTTON_NEGATIVE:
                Toast.makeText(DialogActivity.this, "id = " + which, Toast.LENGTH_SHORT).show();
                break;
            case DialogInterface.BUTTON_NEUTRAL:
                Toast.makeText(DialogActivity.this, "id = " + which, Toast.LENGTH_SHORT).show();
                break;

        }
    }

}
