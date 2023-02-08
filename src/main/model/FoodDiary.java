package model;

import java.util.ArrayList;

//Represents a food diary, with records of foods eaten every day
public class FoodDiary {
    private ArrayList<FoodItem> foodDiary;
    private int weight;
    private int height;
    private int age;
    private String sex;
    private String userName;
    private FoodItem foodItem;
    private float idealIntake;
    private float idealIntake2;


    /*
    Effect: creates an empty diary with userName given
     */
    public FoodDiary(String userName, int weight, int height,int age,String sex) {
        foodDiary = new ArrayList<FoodItem>();
        this.userName = userName;
        this.weight = weight;
        this.height = height;
        this.age = age;
        this.sex = sex;

    }

    // Modifies: this
    // Effects: add a given food item to the diary
    public void addFoodItem(FoodItem foodItem) {
        foodDiary.add(foodItem);
    }

    //Requires:
    //Modifies: this
    // Effects: delete a food item from the diary
    public void deleteFoodItem(String foodName) {
        for (FoodItem foodItem: foodDiary) {
            if (foodName == foodItem.getFoodName()) {
                foodDiary.remove(foodItem);
            }
        }
    }


    // EFFECTS: print out all the food items in the current diary
    public void printDiary() {
        for (FoodItem foodItem: foodDiary) {
            System.out.println(foodItem.getFoodName() + " ==> " + foodItem.getFoodType().toString().toLowerCase());
        }
    }

    // EFFECTS: calculate the ideal calorie intake depends on the gender
    public float calculate() {
        if (this.getSex() == "male") {
            idealIntake = (float) ((67 + (14 * this.getWeight())
                    + (5 * this.getHeight()))
                    / (7 * this.getAge()));
            return idealIntake;
        } else {
            idealIntake2 = (float) ((655 + (9 * this.getWeight())
                                + (2 * this.getHeight()))
                                / (5 * this.getAge()));
            return idealIntake2;
        }
    }


    // getters
    public String getName() {
        return userName;
    }

    public double getWeight() {
        return weight;
    }

    public double getHeight() {
        return height;
    }

    public double getAge() {
        return age;
    }

    public String getSex() {
        return sex;
    }









}
