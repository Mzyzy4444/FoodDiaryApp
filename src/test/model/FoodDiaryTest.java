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
//    private ArrayList<FoodItem> fd;
    private double weight;
    private double height;
    private double age;
    private String sex;
    private String userName;
    private FoodItem apple;
    private double idealIntake;

    @BeforeEach
    public void setup() {
        fdZoey = new FoodDiary("Zoey",50,171,18,"female");
        fdSkye = new FoodDiary("Skye",72,178,18,"male");
//        fd = new ArrayList<FoodItem>();
        apple = new FoodItem("Apple", FoodItem.FoodType.FRUIT);
    }

    @Test
    public void testConstructorFoodDiary() {
        assertEquals("Zoey",fdZoey.getName());
        assertEquals(50,fdZoey.getWeight());
        assertEquals(171,fdZoey.getHeight());
        assertEquals(18,fdZoey.getAge());
        assertEquals("female",fdZoey.getSex());

    }


    @Test
    public void testConstructorFoodItem() {
        assertEquals("Apple", apple.getFoodName());
        assertEquals(FoodItem.FoodType.FRUIT, apple.getFoodType());
    }
    }





//    @Test
//    public void testAddFoodItem() {
//        fdZoey.addFoodItem(apple);
//        assertEquals("Apple",fdZoey.get(0));
//    }
//
//
//