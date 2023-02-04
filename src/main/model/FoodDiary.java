package model;

import java.util.ArrayList;

//Represents a food diary, with records of foods eaten every day
public class FoodDiary {
    private ArrayList<FoodItem> foodDiary;
    private double weight;
    private double height;
    private String userName;
    private FoodItem foodItem;

    /*
    Effect: creates an empty diary with userName given
     */
    public FoodDiary(String userName, double weight, double height) {
        foodDiary = new ArrayList<>();
        this.userName = userName;
        this.weight = weight;
        this.height = height;

    }

    // Modifies: this
    // Effects: add a given food item to the diary
    public void addFoodItem(FoodItem foodItem) {
        foodDiary.add(foodItem);
    }

    //Requires:
    //Modifies: this
    // Effects: delete a food item from the diary
    public void deleteFoodItem(FoodItem foodItem) {
        foodDiary.remove(foodItem);
    }

    // getter
    public String getName() {
        return userName;
    }

    //getter
    public double getWeight() {
        return weight;
    }

    //getter
    public double getHeight() {
        return height;
    }





}
