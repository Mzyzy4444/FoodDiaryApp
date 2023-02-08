package ui;

import model.FoodDiary;
import model.FoodItem;

import java.util.ArrayList;
import java.util.Scanner;

// Food Diary application
public class FoodDiaryApp {
    private FoodDiary foodDiary;
    private ArrayList<String> nameList;
    private ArrayList<String> typeList;
    private String userName;
    private Scanner input;
    private int weight;
    private int height;
    private int age;
    private String sex;

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

    // TODO: set gender notes
    // EFFECTS: display the initial setting selection
    private void displaySetting() {
        System.out.println("\nWelcome to Fit-Foodie!");
        System.out.println("\nplease enter the user name: ");
        foodDiary.setName(input.next() + input.nextLine());
        System.out.println("\nplease enter your weight (in kilograms): ");
        foodDiary.setWeight(input.nextInt());
        System.out.println("\nplease enter your height (in center-meters): ");
        foodDiary.setHeight(input.nextInt());
        System.out.println("\nplease enter your age : ");
        foodDiary.setAge(input.nextInt());
        System.out.println("\nplease enter your gender (male or female) "
                + "// Please note that the gender here is only referring to your physical biology. ");
        foodDiary.setSex(input.next() + input.nextLine());
    }

    //  EFFECTS: display menu options
    private void displayMenu() {
//        System.out.println("\nWelcome to Fit-Foodie!");
        System.out.println("\nPlease select which kinds of food you want record:");
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
    }

    // EFFECTS : add the fruit given to the food diary
    private void addFruit() {
        System.out.println("Please enter the fruit you want to record: ");
        String fruitName = input.next() + input.nextLine();

        FoodItem fruit = new FoodItem(fruitName, FoodItem.FoodType.FRUIT);
        foodDiary.addFoodItem(fruit);
        System.out.println("Fruit recorded");
    }

    // EFFECTS : add the vegetable given to the food diary
    private void addVegetable() {
        System.out.println("Please enter the vegetable you want to record: ");
        String vegName = input.next() + input.nextLine();

        FoodItem veg = new FoodItem(vegName, FoodItem.FoodType.VEGETABLE);
        foodDiary.addFoodItem(veg);
        System.out.println("Vegetable recorded");
    }

    // EFFECTS : add the meat given to the food diary
    private void addMeat() {
        System.out.println("Please enter the meat you want to record: ");
        String meatName = input.next() + input.nextLine();

        FoodItem meat = new FoodItem(meatName, FoodItem.FoodType.MEAT);
        foodDiary.addFoodItem(meat);
        System.out.println("meat recorded");
    }

    // EFFECTS : add the beverage given to the food diary
    private void addBeverages() {
        System.out.println("Please enter the beverage you want to record: ");
        String beName = input.next() + input.nextLine();

        FoodItem bev = new FoodItem(beName, FoodItem.FoodType.BEVERAGES);
        foodDiary.addFoodItem(bev);
        System.out.println("Beverage recorded");
    }

    // EFFECTS : add the snack given to the food diary
    private void addSnacks() {
        System.out.println("Please enter the snack you want to record: ");
        String snkName = input.next() + input.nextLine();

        FoodItem snk = new FoodItem(snkName, FoodItem.FoodType.SNACKS);
        foodDiary.addFoodItem(snk);
        System.out.println("snack recorded");
    }


    // EFFECTS : add the grains given to the food diary
    private void addGrains() {
        System.out.println("Please enter the grains you want to record: ");
        String grnName = input.next() + input.nextLine();

        FoodItem grn = new FoodItem(grnName, FoodItem.FoodType.MEAT);
        foodDiary.addFoodItem(grn);
        System.out.println("Grains recorded");
    }

    // EFFECTS : add the diary given to the food diary
    private void addDairy() {
        System.out.println("Please enter the dairy you want to record: ");
        String dyName = input.next() + input.nextLine();

        FoodItem dy = new FoodItem(dyName, FoodItem.FoodType.MEAT);
        foodDiary.addFoodItem(dy);
        System.out.println("Dairy recorded");
    }

    // MODIFIES: this
    // EFFECTS : delete the food item given from the food diary
    private void deleteItem() {
        System.out.println("Please enter the food you want to delete: ");
        String deleteName = input.next() + input.nextLine();
        foodDiary.deleteFoodItem(deleteName);
    }

    //EFFECTS: print out the ideal calories intake
    private void calculateCalories() {
        System.out.println("The ideal calorie intake for you is " + foodDiary.calculate());
    }


    // EFFECTS: print out what's in the current diary
    private void printOut() {
        System.out.println("The food you recorded in your foodie-diary are: ");
//        for (String name: nameList) {
//            System.out.println(name);
//        }
//        System.out.println("The corresponding food type for each item in the diary are: ");
//        for (String type: typeList) {
//            System.out.println(type);
//        }
        foodDiary.printDiary();

    }



}
