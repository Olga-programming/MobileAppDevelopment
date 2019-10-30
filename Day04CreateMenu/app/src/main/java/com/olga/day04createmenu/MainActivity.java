package com.olga.day04createmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onClick(View view) {

    }

    //create Menu


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //create a submenu : intent Submenu
        SubMenu intentSubmenu = menu.addSubMenu("intent options");

        intentSubmenu.add("Open browser").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                Intent intent = new Intent(Intent.ACTION_VIEW);

                //define our action view
                intent.setData(Uri.parse("http://www.google.com"));

                startActivity(intent);
                return false;
            }
        });

        intentSubmenu.add("open sms screen").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                Intent intent = new Intent(Intent.ACTION_VIEW);

                //Define our Action_View
                intent.setData(Uri.parse("sms:09123456789"));
                intent.putExtra("sms_body","Hello from android application");

                startActivity(intent);
                return false;
            }
        });

        intentSubmenu.add("open dialer").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                Intent intent = new Intent(Intent.ACTION_VIEW);

                //Define our Action_View
                intent.setData(Uri.parse("tel:5145121234"));

                startActivity(intent);
                return false;
            }
        });

        intentSubmenu.add("camera activity").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {

                Intent intent = new Intent(MainActivity.this, CameraActivity.class);
                startActivity(intent);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
}

