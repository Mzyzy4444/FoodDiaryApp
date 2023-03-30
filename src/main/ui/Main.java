package ui;

import ui.gui.GUI;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        try {
            new GUI();
            new FoodDiaryApp();
        } catch (FileNotFoundException e) {
            System.out.println("Unable to run application: file not found");
        }
    }

}