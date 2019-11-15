package ca.masoudbozorgi.a2018_02_06_lifecycle;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    // Just one time -------------------------------------------------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        System.out.println("--------------------- onCreate  : When the activity object create for th first time");
    }


    // From Stop to start ------------------------------
    @Override
    protected void onRestart() {
        super.onRestart();

        System.out.println("--------------------- onRestart : " +
                "Run after Stop state and before Start state");
    }
    //--------------------------------------------------

    @Override
    protected void onStart() {
        super.onStart();

        System.out.println("--------------------- onStart   : " +
                "When activity is becoming visible from stop state");
    }


    @Override
    protected void onResume() {
        super.onResume();

        System.out.println("--------------------- onResume  : " +
                "When the Activity return to foreground from pause or stop state. Always run after onStart().");
    }
    //----------------------------------------------------------------------------------------------


    @Override
    protected void onPause() {
        super.onPause();

        System.out.println("--------------------- onPause  : " +
                "When activity is no longer in the foreground, " +
                "but it can be visible like when an alert is on top of an activity");
        Log.d("myTag", ">>>>>>>>>>>>>>>>>>>> This is a message from Lod.d");
    }

    @Override
    protected void onStop() {
        super.onStop();

        System.out.println("--------------------- onStop   : " +
                "When activity is no longer visible");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        System.out.println("--------------------- onDestroy : When an activity is about to be destroyed and completely remove from RAM");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuItem item = menu.add("GET");
        menu.add("Post");
        menu.add("Http");
        item.setShowAsAction(MenuItem.SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW);

        item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                Toast.makeText(MainActivity.this, "menuItemClicked: " + menuItem.getItemId(), Toast.LENGTH_LONG).show();

                return true;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    public void goToSecondActivity(View view) {

        startActivity(new Intent(this, SecondActivity.class));
    }


    //AlertDialog.Builder onClick ------------------------------------------------------------------
    public void showAlertDialog(View view) {

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

        alertDialogBuilder.setTitle("This is my title");
        AlertDialog alertDialog = alertDialogBuilder.create();

        alertDialog.show();
    }
}
