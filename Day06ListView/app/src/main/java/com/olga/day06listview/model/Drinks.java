package com.olga.day06listview.model;

import com.olga.day06listview.DrinkActivity;
import com.olga.day06listview.R;

public class Drinks {
    private String name;
    private String description;
    private int imageResourseId;

    public Drinks(String name, String description, int imageResourseId) {
        this.name = name;
        this.description = description;
        this.imageResourseId = imageResourseId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImageResourseId(int imageResourseId) {
        this.imageResourseId = imageResourseId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getImageResourseId() {
        return imageResourseId;
    }

    public String toString(){return this.name;}

    public static final Drinks[] drinks = {
            new Drinks( "Latte", "Description  of LAtte", R.drawable.latte),
            new Drinks( "Capuccino", "Description  of Capuccino", R.drawable.apricot),
            new Drinks( "Filtered", "Description  of Filtered", R.drawable.heart_green),

    };
}
