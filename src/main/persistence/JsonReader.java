package persistence;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import model.FoodDiary;
import model.FoodItem;
import org.json.*;

public class JsonReader {
    private String source;

    private String userName;
    private int weight;
    private int height;
    private int age;
    private String sex;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
//        this.foodDiary = new FoodDiary(userName, weight,height,age,sex);
    }

    // EFFECTS: reads food-diary from file and returns it;
    // throws IOException if an error occurs reading data from file
    public FoodDiary read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseFoodDiary(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses food diary from JSON object and returns it
    private FoodDiary parseFoodDiary(JSONObject jsonObject) {

        String userName = jsonObject.getString("userName");
        int weight = jsonObject.getInt("weight");
        int height = jsonObject.getInt("height");
        int age = jsonObject.getInt("age");
        String sex = jsonObject.getString("sex");

        FoodDiary fd = new FoodDiary(userName, weight,height,age,sex);
        addFoodItems(fd, jsonObject);
        return fd;
    }

    // MODIFIES: fd
    // EFFECTS: parses food items from JSON object and adds them to workroom
    private void addFoodItems(FoodDiary fd, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("food items");
        for (Object json : jsonArray) {
            JSONObject nextFoodie = (JSONObject) json;
            addFoodItem(fd, nextFoodie);
        }
    }


    private void addFoodItem(FoodDiary fd, JSONObject jsonObject) {
        String foodItem = jsonObject.getString("food name");
        String foodTypeString = jsonObject.getString("food type");
        FoodItem.FoodType foodType = FoodItem.FoodType.valueOf(foodTypeString);

        FoodItem foodie = new FoodItem(foodItem, foodType);
        fd.addFoodItem(foodie);
    }

}
