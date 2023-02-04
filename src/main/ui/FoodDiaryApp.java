package ui;

import model.FoodDiary;

import java.sql.SQLOutput;
import java.util.Scanner;

// Food Diary application
public class FoodDiaryApp {
    private FoodDiary foodDiary;
    private Scanner userName;
    private Scanner input;

    //EFFECTS : runs the food diary app
    public FoodDiaryApp() {
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
    //  FRUIT, VEGETABLE, MEAT, SEAFOOD, DAIRY, GRAINS, NUT, SNACKS, BEVERAGES
    private void processCommand(String command) {
        if (command.equals("f")) {
            addFruit();
        } else if (command.equals("v")) {
            addVegetable();
        } else if (command.equals("m")) {
            addMeat();
        } else if (command.equals("sea")) {
            addSeafood();
        } else if (command.equals("d")) {
            addDiary();
        } else if (command.equals("g")) {
            addGrains();
        } else if (command.equals("n")) {
            addNut();
        } else if (command.equals("s")) {
            addSnacks();
        } else if (command.equals("b")) {
            addBeverages();
        } else {
            System.out.println("Sorry, we are unable to find this selection");
        }
    }


    //MODIFIES : this
    // EFFECTS : initialized diary
    private void init() {
        foodDiary = new FoodDiary("Zoey",48,172);
        input = new Scanner(System.in);
        input.useDelimiter("\n");

    }

    //  FRUIT, VEGETABLE, MEAT, SEAFOOD, DAIRY, GRAINS, NUT, SNACKS, BEVERAGES
    private void displayMenu() {
        System.out.println("\nWelcome to Fit-Foodie!");
        System.out.println("\nPlease select which kinds of food you want record:");
        System.out.println("\nf -> Fruit");
        System.out.println("\nv -> Vegetable");
        System.out.println("\nm -> Meat");
        System.out.println("\nsea -> Seafood");
        System.out.println("\nd -> Dairy");
        System.out.println("\ng -> Grains");
        System.out.println("\nn -> Nuts");
        System.out.println("\ns -> Snacks");
        System.out.println("\nb -> Beverages");
    }

    private void addFruit() {}

    private void addVegetable() {}

    private void addMeat() {}

    private void addSeafood() {
    }

    private void addBeverages() {
    }

    private void addSnacks() {
    }

    private void addNut() {
    }

    private void addGrains() {
    }

    private void addDiary() {
    }



}
