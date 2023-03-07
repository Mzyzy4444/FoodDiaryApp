package ui;

import model.FoodDiary;
import model.FoodItem;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

// Food Diary application
public class FoodDiaryApp {
    private static final String JSON_STORE = "./data/food-diary.json";
    private FoodDiary foodDiary;
    private Scanner input;
    private String userName;
    private int weight;
    private int height;
    private int age;
    private String sex;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;


    //EFFECTS : runs the food diary app
    public FoodDiaryApp() throws FileNotFoundException {
        input = new Scanner(System.in);
        foodDiary = new FoodDiary("Zoey",weight,height,age,sex);
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
        runFoodDiaryApp();
    }

    // MODIFIES: this;
    // EFFECTS: processes user input
    private void runFoodDiaryApp() {
        boolean keepGoing = true;
        String command = null;

        init();

        while (keepGoing) {
            displayMenu();
            command = input.next();
            command = command.toLowerCase();

            if (command.equals("q")) {
                keepGoing = false;

            } else {
                processCommand(command);
            }
        }
        System.out.println("See you next meal!");

    }


    // MODIFIES: this
    // EFFECTS: process user command
    // and jump to the selected categories
    @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
    private void processCommand(String command) {
        if (command.equals("f")) {
            addFruit();
        } else if (command.equals("v")) {
            addVegetable();
        } else if (command.equals("m")) {
            addMeat();
        } else if (command.equals("d")) {
            addDairy();
        } else if (command.equals("g")) {
            addGrains();
        } else if (command.equals("s")) {
            addSnacks();
        } else if (command.equals("b")) {
            addBeverages();
        } else if (command.equals("view")) {
            printOut();
        } else if (command.equals("delete")) {
            deleteItem();
        } else if (command.equals("c")) {
            calculateCalories();
        } else if (command.equals("save")) {
            saveFoodDiary();
        } else if (command.equals("load")) {
            loadFoodDiary();
        } else {
            System.out.println("Sorry, we are unable to find this selection");
        }
    }


    //MODIFIES : this
    // EFFECTS : initialized diary
    private void init() {
        foodDiary = new FoodDiary(userName,weight,height,age,sex);
        input = new Scanner(System.in);
        input.useDelimiter("\n");
        displaySetting();

    }

    // EFFECTS: display the initial setting selection
    private void displaySetting() {
        System.out.println("\nWelcome to Fit-Foodie!");
        System.out.println("\nPlease enter the user name: ");
        foodDiary.setName(input.next() + input.nextLine());
        System.out.println("\nPlease enter your weight (in kilograms): ");
        foodDiary.setWeight(input.nextInt());
        System.out.println("\nPlease enter your height (in center-meters): ");
        foodDiary.setHeight(input.nextInt());
        System.out.println("\nPlease enter your age : ");
        foodDiary.setAge(input.nextInt());
        System.out.println("\nPlease enter your gender (male or female) "
                + "// Please note that the gender here is only referring to your physical biology. ");
        foodDiary.setSex(input.next() + input.nextLine());
    }

    //  EFFECTS: display menu options
    private void displayMenu() {
        System.out.println("\nPlease select which kind of food you want record:");
        System.out.println("\nf -> Fruit");
        System.out.println("\nv -> Vegetable");
        System.out.println("\nm -> Meat (including seafood)");
        System.out.println("\nd -> Dairy");
        System.out.println("\ng -> Grains");
        System.out.println("\ns -> Snacks");
        System.out.println("\nb -> Beverages");
        System.out.println("\nview -> view my diary");
        System.out.println("\ndelete -> delete food item in my diary");
        System.out.println("\nc -> calculate the appropriate calories based on your body condition");
        System.out.println("\nq -> quit");
        System.out.println("\tsave -> save work room to file");
        System.out.println("\tload -> load work room from file");
    }

    

    // MODIFIES: foodDiary
    // EFFECTS : add the fruit given to the food diary
    private void addFruit() {
        System.out.println("Please enter the fruit you want to record: ");
        String fruitName = input.next() + input.nextLine();

        FoodItem fruit = new FoodItem(fruitName, FoodItem.FoodType.FRUIT);
        foodDiary.addFoodItem(fruit);
        System.out.println("Fruit recorded");
    }

    // MODIFIES: foodDiary
    // EFFECTS : add the vegetable given to the food diary
    private void addVegetable() {
        System.out.println("Please enter the vegetable you want to record: ");
        String vegName = input.next() + input.nextLine();

        FoodItem veg = new FoodItem(vegName, FoodItem.FoodType.VEGETABLE);
        foodDiary.addFoodItem(veg);
        System.out.println("Vegetable recorded");
    }

    // MODIFIES: foodDiary
    // EFFECTS : add the meat given to the food diary
    private void addMeat() {
        System.out.println("Please enter the meat you want to record: ");
        String meatName = input.next() + input.nextLine();

        FoodItem meat = new FoodItem(meatName, FoodItem.FoodType.MEAT);
        foodDiary.addFoodItem(meat);
        System.out.println("meat recorded");
    }

    // MODIFIES: foodDiary
    // EFFECTS : add the beverage given to the food diary
    private void addBeverages() {
        System.out.println("Please enter the beverage you want to record: ");
        String beName = input.next() + input.nextLine();

        FoodItem bev = new FoodItem(beName, FoodItem.FoodType.BEVERAGES);
        foodDiary.addFoodItem(bev);
        System.out.println("Beverage recorded");
    }

    // MODIFIES: foodDiary
    // EFFECTS : add the snack given to the food diary
    private void addSnacks() {
        System.out.println("Please enter the snack you want to record: ");
        String snkName = input.next() + input.nextLine();

        FoodItem snk = new FoodItem(snkName, FoodItem.FoodType.SNACKS);
        foodDiary.addFoodItem(snk);
        System.out.println("snack recorded");
    }

    // MODIFIES: foodDiary
    // EFFECTS : add the grains given to the food diary
    private void addGrains() {
        System.out.println("Please enter the grains you want to record: ");
        String grnName = input.next() + input.nextLine();

        FoodItem grn = new FoodItem(grnName, FoodItem.FoodType.MEAT);
        foodDiary.addFoodItem(grn);
        System.out.println("Grains recorded");
    }

    // MODIFIES: foodDiary
    // EFFECTS : add the diary given to the food diary
    private void addDairy() {
        System.out.println("Please enter the dairy you want to record: ");
        String dyName = input.next() + input.nextLine();

        FoodItem dy = new FoodItem(dyName, FoodItem.FoodType.MEAT);
        foodDiary.addFoodItem(dy);
        System.out.println("Dairy recorded");
    }

    // MODIFIES: foodDiary
    // EFFECTS : delete the food item given from the food diary
    private void deleteItem() {
        System.out.println("Please enter the food you want to delete: ");
        String deleteName = input.next() + input.nextLine();
        foodDiary.deleteFoodItem(deleteName);
    }

    //EFFECTS: print out the ideal calories intake
    private void calculateCalories() {
        System.out.println("The ideal calorie intake for you is " + foodDiary.calculate() + " kcal");
    }


    // EFFECTS: print out what's in the current diary
    private void printOut() {
        System.out.println("The food you recorded in your foodie-diary are: ");
        //System.out.println(foodDiary.printDiary());
        for (String element : foodDiary.printDiaryViewList()) {
            System.out.println(element);
        }

    }

    // EFFECTS: saves the food diary to file
    private void saveFoodDiary() {
        try {
            jsonWriter.open();
            jsonWriter.write(foodDiary);
            jsonWriter.close();
            System.out.println("Saved " + foodDiary.getName() + " to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    // MODIFIES: this
    // EFFECTS: loads food diary from file
    private void loadFoodDiary() {
        try {
            foodDiary = jsonReader.read();
            System.out.println("Loaded " + foodDiary.getName() + " from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }



}
