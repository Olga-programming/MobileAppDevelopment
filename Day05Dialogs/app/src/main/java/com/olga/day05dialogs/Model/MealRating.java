package com.olga.day05dialogs.Model;

public class MealRating implements Comparable<MealRating>{
    String mealName;
    int mealRating;

    public MealRating() {
    }

    public MealRating(String mealName, int mealRating) {
        this.mealName = mealName;
        this.mealRating = mealRating;
    }

    public String getMealName() {
        return mealName;
    }

    public int getMealRating() {
        return mealRating;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public void setMealRating(int mealRating) {
        this.mealRating = mealRating;
    }

    @Override
    public String toString() {
        return "Meal: " + mealName + "Rating " + mealRating;
    }

    @Override
    public int compareTo(MealRating mealRating) {
        return mealName.compareTo(mealRating.getMealName());
    }


}
