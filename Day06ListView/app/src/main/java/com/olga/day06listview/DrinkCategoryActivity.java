package com.olga.day06listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.olga.day06listview.model.Drinks;

public class DrinkCategoryActivity extends AppCompatActivity {

    public static final String EXTRA_DRINKID = "drinkId";
    TextView name, description;
    ImageView photo;
    Drinks drink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink_category);

        initialize();
        getMyIntent();
        populateData();
    }

    private void populateData() {
        name.setText(drink.getName());
        description.setText(drink.getDescription());
        photo.setImageResource(drink.getImageResourseId());
        photo.setContentDescription(drink.getName());
    }

    private void getMyIntent() {
        int drinkId = (Integer)getIntent().getExtras().get(EXTRA_DRINKID);
        drink = Drinks.drinks[drinkId];

    }

    private void initialize() {
        name = findViewById(R.id.name);
        description = findViewById(R.id.description);
        photo = findViewById(R.id.photo);

    }





}
