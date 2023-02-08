package model;

public class FoodItem {
    private String foodItem;
    private FoodType foodType;

    public enum FoodType {
        FRUIT, VEGETABLE, MEAT, DAIRY, GRAINS, SNACKS, BEVERAGES
    }

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
