package model;

public class FoodItem {
    private String foodItem;
    private FoodType foodType;

    public enum FoodType {
        FRUIT, VEGETABLE, MEAT, SEAFOOD, DAIRY, GRAINS, NUT, SNACKS, BEVERAGES
    }

    public FoodItem(String foodName, FoodType foodType) {
        foodItem = foodName;
        this.foodType = foodType;
    }

    //getters
    public String getName() {
        return foodItem;
    }

    //getters
    public FoodType getType() {
        return foodType;
    }


}
