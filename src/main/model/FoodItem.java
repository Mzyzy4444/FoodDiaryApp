package model;

public class FoodItem {
    private String foodItem;
    private FoodType foodType;

    public enum FoodType {
        FRUIT, VEGETABLE, MEAT, DAIRY, GRAINS, SNACKS, BEVERAGES
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
