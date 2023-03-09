package persistence;

import model.FoodItem;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonTest {

    protected void checkFoodItem(String foodName, FoodItem.FoodType foodType, FoodItem foodItem){
        assertEquals(foodName, foodItem.getFoodName());
        assertEquals(foodType, foodItem.getFoodType());
    }


}
