package com.olga.day04lifesycleapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_main);

        System.out.println("______________________onCreate : when the activity object create for the first time");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        System.out.println("______________________onRestart : Run after stop state and before star state");
    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("______________________onStart : when activity is becominng visible from stop state");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("______________________onResume : when activity returnto foreroung from pause or dtop state.Always run after onStart()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("______________________onPause : " +
                "When activity is no linger in the foreground," +
                "but it is can be visible like when an alert is on top of an activity");
        Log.d("muTAg",">>>>>>>>>>>>>This is message from log");
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}
