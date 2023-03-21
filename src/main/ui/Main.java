package ui;

import ui.Gui.Gui;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        try {
            new Gui();
            new FoodDiaryApp();
        } catch (FileNotFoundException e) {
            System.out.println("Unable to run application: file not found");
        }
    }

}