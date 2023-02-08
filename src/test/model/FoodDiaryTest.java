package model;


import org.junit.jupiter.api.BeforeEach;
import model.FoodDiary;
import model.FoodItem;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FoodDiaryTest {
    private FoodDiary fdZoey;
    private FoodDiary fdSkye;
    private FoodDiary fdJeffery;
    private double weight;
    private double height;
    private double age;
    private String sex;
    private String userName;
    private FoodItem apple;
    private FoodItem chicken;
    private double idealIntake;


    @BeforeEach
    public void setup() {
        fdZoey = new FoodDiary("Zoey", 50, 171, 18, "female");
        fdSkye = new FoodDiary("Skye", 72, 178, 18, "male");
        fdJeffery = new FoodDiary("Jeffery",72,176,20,"male");
//        fd = new ArrayList<FoodItem>();
        apple = new FoodItem("Apple", FoodItem.FoodType.FRUIT);
        chicken = new FoodItem("Chicken",FoodItem.FoodType.MEAT);
    }

    @Test
    public void testConstructorFoodDiary() {
        assertEquals("Zoey", fdZoey.getName());
        assertEquals(50, fdZoey.getWeight());
        assertEquals(171, fdZoey.getHeight());
        assertEquals(18, fdZoey.getAge());
        assertEquals("female", fdZoey.getSex());

    }


    @Test
    public void testConstructorFoodItem() {
        assertEquals("Apple", apple.getFoodName());
        assertEquals(FoodItem.FoodType.FRUIT, apple.getFoodType());
    }


    @Test
    public void testAddFoodItem() {
        fdZoey.addFoodItem(apple);
        assertEquals(1, fdZoey.getSize());
    }

    @Test
    public void testAddMultipleFoodItem() {
        fdJeffery.addFoodItem(apple);
        fdJeffery.addFoodItem(chicken);
        assertEquals(2,fdJeffery.getSize());
    }

    @Test
    public void testDeleteFoodItem() {
        fdSkye.addFoodItem(apple);
        assertEquals(1, fdSkye.getSize());
        fdSkye.deleteFoodItem("Apple");
        assertEquals(0,fdSkye.getSize());
    }

    @Test
    public void testPrintDiary() {}

    @Test
    public void testCalculateMale() {}

    @Test
    public void testCalculateFemale() {}





}


