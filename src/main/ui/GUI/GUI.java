package ui.GUI;


import model.FoodDiary;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame implements ActionListener {
    private FoodDiary fd;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    private JPanel loadPanel;
    private JPanel menuPanel;

    private JButton loadButton;
    private JButton loadNoButton;
    private JLabel welcomeLabel;
    private JLabel nameLabel;
    private JLabel logoLabel;


    private static final String JSON_SAVE = "./data/food-diary.json";

    // Make a new JFrame with different attributes
    public GUI() {
        super(" Food Diary App");

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(500, 500);
        this.getContentPane().setBackground(new Color(229, 255, 204));


        initializeLoadPanel();
        makeMenuLabel();
        setLoadButton();
        addActionToButton();


        this.setVisible(true);

        loadPanel.setVisible(true);

    }

    // EFFECTS: Initializes load menu buttons and gives them labels
    private void setLoadButton() {
        loadButton = new JButton("Yes");
        loadNoButton = new JButton("No");
        addButton(loadButton, loadPanel);
        addButton(loadNoButton, loadPanel);
    }

    // MODIFIES: this
    // EFFECTS: adds buttons to loadMenu
    public void addButton(JButton button1, JPanel panel) {
        button1.setFont(new Font("Comic Sans", Font.BOLD, 12));
        button1.setBackground(Color.white);
        panel.add(button1);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
    }

    // MODIFIES: this
    // EFFECTS: Sets each button to their respective action
    public void addActionToButton() {

        loadButton.addActionListener(this);
        loadButton.setActionCommand("Load");
        loadNoButton.addActionListener(this);
        loadNoButton.setActionCommand("Input new info");
    }


//        initializeMenu();
//        initializeMenuButtons();


    // MODIFIES: this
    // EFFECTS: Creates the panel that displays the mian menu
    public void makeMenuLabel() {
        menuPanel = new JPanel();
        menuPanel.setBackground(new Color(0, 255, 204));

//
    }


    @Override
    // EFFECTS: calls the given methods when a certain button is clicked on
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Input new info")) {
            //initializeInputPanel();
        } else if (e.getActionCommand().equals("Load")) {
            loadData();
            initializeMenuPanel();
        }


    }

    public void initializeLoadPanel() {
        loadPanel = new JPanel();
        loadPanel.setBackground(new Color(229, 255, 204));
        add(loadPanel);
        loadPanel.setPreferredSize(new Dimension(500, 500));
        //menuPanel.setBounds(0,0,250,250);

        welcomeLabel = new JLabel();
        welcomeLabel.setText("Welcome to Fit-Foodie!");
        welcomeLabel.setFont(new Font("Comic Sans", Font.BOLD, 25));
        welcomeLabel.setSize(300, 100);
        welcomeLabel.setVisible(true);

        logoLabel = new JLabel();
        logoLabel.setIcon(new ImageIcon("ui/GUI/logo.png"));
        logoLabel.setPreferredSize(new Dimension(300,300));

        loadPanel.add(logoLabel);
        loadPanel.add(welcomeLabel);


    }

    //TODO
    // MODIFIES: this
    // EFFECTS: loads the car listings from json file if it exists,
    // otherwise prints error
    public void loadData() {
    }


    public void initializeMenuPanel() {
        add(menuPanel);
        menuPanel.setPreferredSize(new Dimension(500, 500));
        loadPanel.setVisible(false);



        nameLabel = new JLabel();
        nameLabel.setText("Fit-Foodie");
        nameLabel.setVisible(true);
        nameLabel.setFont(new Font("Comic Sans", Font.BOLD, 25));
        nameLabel.setSize(300, 100);
        menuPanel.add(nameLabel);


    }


}



