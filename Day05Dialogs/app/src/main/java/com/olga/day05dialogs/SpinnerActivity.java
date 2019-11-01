package com.olga.day05dialogs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.olga.day05dialogs.Model.MealRating;

import java.util.ArrayList;
import java.util.Collections;

public class SpinnerActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {
    ImageView imgSpinner;
    Button btnSpinnerAdd, btnSpinnerShowAll;
    RatingBar ratingSpinner;

    Spinner spinnerMeal;

    ArrayList<MealRating> lisOfMealRating;

    ArrayAdapter<String> mealAdapter;

    String lisOfMeal[] = {"Salmon", "Putine", "Dessert", "Tacos"};
    int mealPicture[] = {R.drawable.apple, R.drawable.apricot, R.drawable.cherry, R.drawable.strawberry};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        initialize();
    }

    private void initialize() {
        lisOfMealRating = new ArrayList<>();
        imgSpinner = findViewById(R.id.imgSpinner);

        btnSpinnerAdd = findViewById(R.id.btnSpinnerAdd);
        btnSpinnerAdd.setOnClickListener(this);

        btnSpinnerShowAll = findViewById(R.id.btnSpinnerShawAll);
        btnSpinnerShowAll.setOnClickListener(this);

        ratingSpinner = findViewById(R.id.ratingSpinner);
        spinnerMeal = findViewById(R.id.spinner);
        spinnerMeal.setOnItemSelectedListener(this);

        mealAdapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, lisOfMeal);
        spinnerMeal.setAdapter(mealAdapter);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnSpinnerAdd:
                addRating();
                break;
            case R.id.btnSpinnerShawAll:
                showAll();
                break;
        }
    }

    private void showAll() {
        Collections.sort(lisOfMealRating);
        StringBuilder sb = new StringBuilder("");
        for(MealRating m: lisOfMealRating){
            sb.append(m + "\n");
        }
        Toast.makeText(this,sb.toString(), Toast.LENGTH_SHORT).show();
    }

    private void addRating() {
        String meal = spinnerMeal.getSelectedItem().toString();
        int rating = (int)ratingSpinner.getRating();

        MealRating mealRating = new MealRating(meal, rating);
        lisOfMealRating.add(mealRating);

        ratingSpinner.setRating(0);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {
        int image = mealPicture[i];
        imgSpinner.setImageResource(image);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
