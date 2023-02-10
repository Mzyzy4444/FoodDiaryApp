package model;

import java.util.ArrayList;
import java.util.List;

//Represents a food diary, with records of foods eaten every day
public class FoodDiary {
    private ArrayList<FoodItem> foodDiary;
    private int weight;
    private int height;
    private int age;
    private String sex;
    private String userName;



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

    //Requires: The food item must be in the food diary before;
    //          only delete one food item at a time
    //Modifies: this
    // Effects: delete a food item from the diary
    public void deleteFoodItem(String foodName) {
        for (FoodItem foodItem: foodDiary) {
            if (foodName.equals(foodItem.getFoodName())) {
                foodDiary.remove(foodItem);
                break;
            }
        }
    }


    // EFFECTS: print out all the food items in the current diary
    public List<String> printDiaryViewList() {
        List<String> viewList = new ArrayList<String>();
        for (FoodItem foodItem: foodDiary) {
            String s = foodItem.getFoodName() + " ==> " + foodItem.getFoodType().toString().toLowerCase();
            viewList.add(s);
        }
        return viewList;
    }

    // EFFECTS: calculate the ideal calorie intake based on the gender
    public int calculate() {
        if (this.getSex() == "male") {
            int idealIntake = (int) (1.9 * ((10 * this.getWeight())
                    + (6.25 * this.getHeight()) - (5 * this.getAge()) + 5));
            return idealIntake;
        } else {
            int idealIntake2 = (int) (1.9 * ((10 * this.getWeight())
                    + (6.25 * this.getHeight()) - (5 * this.getAge()) - 161));
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

    public int getSize() {
        return foodDiary.size();
    }

    // setters
    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setName(String userName) {
        this.userName = userName;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }









}