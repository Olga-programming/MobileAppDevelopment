package com.olga.day07customlistview;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.telecom.Call;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.olga.day07customlistview.xml_json.Json_Parser;
import com.olga.day07customlistview.xml_json.Xml_Parser;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements
        View.OnClickListener,
        AdapterView.OnItemClickListener,
        AdapterView.OnItemLongClickListener {

    ListView mainListView;
    Button btnMainJson, btnMainXML, btnMainDB;
    ArrayList<Flower> flowerArrayList  = new ArrayList<>();
    CellControllerBaseAdapter cellControllerBaseAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();
        //initializeModel();
        initializeCustomList();
    }

    private void initializeModel() {
        Flower flower1 = new Flower();
    }

    private void initializeCustomList() {


        //test
        /*
        ArrayList<String> abcTest = new ArrayList<>();
        abcTest.add("test");
        abcTest.add("test");
        abcTest.add("test");


        ArrayAdapter<String> listAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                abcTest);

        mainListView.setAdapter(listAdapter);*/
        cellControllerBaseAdapter = new CellControllerBaseAdapter(this, flowerArrayList);
        mainListView.setAdapter(cellControllerBaseAdapter);

    }

    private void initialize() {
        mainListView = findViewById(R.id.mainListView);
        mainListView.setOnItemClickListener(this);
        mainListView.setOnItemLongClickListener(this);


        btnMainJson = findViewById(R.id.btnMainJson);
        btnMainJson.setOnClickListener(this);
        btnMainXML = findViewById(R.id.btnMainXML);
        btnMainXML.setOnClickListener(this);
        btnMainDB = findViewById(R.id.btnMainDB);
        btnMainDB.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnMainJson:
                Json_Parser json_parser = new Json_Parser();
                flowerArrayList = json_parser.processJSONFile(this, "flowers_json");
                cellControllerBaseAdapter = new CellControllerBaseAdapter(this, flowerArrayList);
                mainListView.setAdapter(cellControllerBaseAdapter);
                break;
            case R.id.btnMainXML:
                Xml_Parser xml_parser = new Xml_Parser(this);
                flowerArrayList = xml_parser.parseXML();
                cellControllerBaseAdapter = new CellControllerBaseAdapter(this, flowerArrayList);
                mainListView.setAdapter(cellControllerBaseAdapter);
                break;
            case R.id.btnMainDB:
                break;

        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        startActivity(new Intent(this, DetailActivity.class));
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
        showAlertDialog(view);

        //changed to true
        return true;
    }

    private void showAlertDialog(View view) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);

        /*builder.setMessage("Alert Dialog Title")
                .setMessage("Do you want to delete this file?")
                .setCancelable(false)
                .setIcon(android.R.drawable.ic_dialog_info)
                .setPositiveButton("Yes", (dialogInretface, i))
*/

        builder.show();
    }
}
