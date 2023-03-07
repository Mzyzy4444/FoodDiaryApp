package model;

import org.json.JSONObject;
import persistence.Writable;

public class FoodItem implements Writable {
    private String foodItem;
    private FoodType foodType;

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("food name", foodItem);
        json.put("food type", foodType);
        return json;
    }

    public enum FoodType {
        FRUIT, VEGETABLE, MEAT, SNACKS, BEVERAGES
    }

    // REQUIRES: food type must be in the FoodType enum
    // EFFECTS: construct a food item with given foodName and food type
    public FoodItem(String foodName, FoodType foodType) {
        foodItem = foodName;
        this.foodType = foodType;
    }

    //getters
    public String getFoodName() {
        return foodItem;
    }

    //getters
    public FoodType getFoodType() {
        return foodType;
    }


}
