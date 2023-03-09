package persistence;

import model.FoodDiary;
import model.FoodItem;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JsonWriterTest extends JsonTest{

    @Test
    void testWriterInvalidFile() {
        try {
            FoodDiary fd = new FoodDiary("Jeffrey",75,176,20,"male");
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

//
    @Test
    void testWriterEmptyFoodDiary() {
        try {
            FoodDiary fd = new FoodDiary("Jeffrey",75,176,20,"male");
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyFoodDiary.json");
            writer.open();
            writer.write(fd);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyFoodDiary.json");
            fd = reader.read();
            assertEquals("Jeffrey", fd.getName());
            assertEquals(0, fd.numFoodItems());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralWorkroom() {
        try {
            FoodDiary fd = new FoodDiary("Jeffrey",75,176,20,"male");
            fd.addFoodItem(new FoodItem("tomato", FoodItem.FoodType.VEGETABLE));
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralFoodDiary.json");
            writer.open();
            writer.write(fd);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralFoodDiary.json");
            fd = reader.read();
            assertEquals("Jeffrey", fd.getName());
            List<FoodItem> foodItems = fd.getFoodItems();
            assertEquals(1, foodItems.size());
            checkFoodItem("tomato", FoodItem.FoodType.VEGETABLE, foodItems.get(0));

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}
