package model;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class FoodDiaryTest {
    private FoodDiary fdZoey;
    private FoodDiary fdSkye;
    private FoodDiary fdJeffery;
    private FoodItem apple;
    private FoodItem chicken;


    @BeforeEach
    public void setup() {
        fdZoey = new FoodDiary("Zoey", 48, 171, 18, "female");
        fdSkye = new FoodDiary("Skye", 72, 178, 18, "male");
        fdJeffery = new FoodDiary("Jeffery",65,176,20,"male");
//        fd = new ArrayList<FoodItem>();
        apple = new FoodItem("Apple", FoodItem.FoodType.FRUIT);
        chicken = new FoodItem("Chicken",FoodItem.FoodType.MEAT);
    }

    @Test
    public void testConstructorFoodDiary() {
        assertEquals("Zoey", fdZoey.getName());
        assertEquals(48, fdZoey.getWeight());
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
        try {
            fdSkye.deleteFoodItem("Apple");

        } catch (Exception e) {
            fail();
        }
    }


    @Test
    public void testDeleteFoodItemNotInDiary() {
        fdSkye.addFoodItem(apple);
        assertEquals(1, fdSkye.getSize());
        try {
            fdSkye.deleteFoodItem("Prange");
            fail();
        } catch (Exception e) {
            assertEquals(1, fdSkye.getSize());
        }
    }

    @Test
    public void testDeleteFoodItemEmpty() {
        assertEquals(0, fdSkye.getSize());
        try {
            fdSkye.deleteFoodItem("Apple");
        } catch (Exception e) {
            assertEquals(0, fdSkye.getSize());
        }
    }

    @Test
    public void testPrintDiaryEmpty() {
        assertEquals(0, fdZoey.printDiaryViewList().size());
    }

    @Test
    public void testPrintDiaryNotEmpty() {
        assertEquals(0, fdZoey.printDiaryViewList().size());
        fdZoey.addFoodItem(apple);
        fdZoey.addFoodItem(chicken);
        assertEquals(2,fdZoey.printDiaryViewList().size());
    }

    @Test
    public void testCalculateMale() {
        assertEquals(3320, fdSkye.calculate());
    }

    @Test
    public void testCalculateFemale() {
        assertEquals(2465,fdZoey.calculate());
    }

    @Test
    public void testSetWeight() {
        fdJeffery.setWeight(100);
        assertEquals(100,fdJeffery.getWeight());
    }

    @Test
    public void testSetName() {
        fdSkye.setName("Joker");
        assertEquals("Joker",fdSkye.getName());
    }

    @Test
    public void testSetHeight() {
        fdJeffery.setHeight(150);
        assertEquals(150,fdJeffery.getHeight());
    }

    @Test
    public void testSetAge() {
        fdJeffery.setAge(18);
        assertEquals(18,fdJeffery.getAge());
    }

    @Test
    public void testSetSex() {
        fdJeffery.setSex("female");
        assertEquals("female",fdJeffery.getSex());
    }






}


