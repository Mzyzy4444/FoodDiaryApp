package persistence;

import model.FoodDiary;
import model.FoodItem;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JsonReaderTest extends JsonTest {

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            FoodDiary fd = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyFoodDiary() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyFoodDiary.json");
        try {
            FoodDiary fd = reader.read();
            assertEquals("Zoey", fd.getName());
            assertEquals(0, fd.numFoodItems());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralWorkRoom() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralWorkRoom.json");
        try {
            FoodDiary fd = reader.read();
            assertEquals("Skye", fd.getName());
            List<FoodItem> foodItems = fd.getFoodItems();
            assertEquals(1, foodItems.size());
            checkFoodItem("chicken", FoodItem.FoodType.MEAT, foodItems.get(0));
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}
