package com.olga.day06listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.olga.day06listview.model.Drinks;

public class DrinkActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);

        initialize();
    }

    private void initialize() {
        ListView listDrinks = findViewById(R.id.list_drinks);

        ArrayAdapter<Drinks> listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Drinks.drinks);
        listDrinks.setAdapter(listAdapter);

        AdapterView.OnItemClickListener itemClickListener =
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView,
                                            View view,
                                            int position,
                                            long id) {
                        Intent intent = new Intent(DrinkActivity.this, DrinkCategoryActivity.class);
                        intent.putExtra(DrinkCategoryActivity.EXTRA_DRINKID,(int)id);
                        startActivity(intent);


                    }
                };

        listDrinks.setOnItemClickListener(itemClickListener);

    }

}
