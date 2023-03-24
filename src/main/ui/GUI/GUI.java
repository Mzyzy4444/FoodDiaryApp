package ui.GUI;


import model.FoodDiary;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame implements ActionListener {
    private FoodDiary fd;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    private JPanel loadPanel;
    private JPanel menuPanel;
    private JPanel addLeftPanel;
    private JPanel addRightPanel;

    private JButton returnButton;
    private JButton loadButton;
    private JButton loadNoButton;
    private JButton addButton;
    private JButton saveButton;
    private JButton viewButton;
    private JButton addFoodButton;


    private JComboBox typeBox;

    private JTextArea textArea;
    private  JTextField foodInputField;


    private JLabel welcomeLabel;
    private JLabel nameLabel;
    private JLabel logoLabel;
    private JLabel typeAsking;
    private JLabel foodAsking;




    private static final String JSON_SAVE = "./data/food-diary.json";

    // Make a new JFrame with different attributes
    public GUI() {
        super(" Food Diary App");

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(500, 500);
        //229,255,204

        initializeLoadPanel();
        makeMenuPanel();
        makeAddPanel();
        setButtons();
        addActionToButton();


        this.setVisible(true);
        loadPanel.setVisible(true);

    }

    // EFFECTS: Initializes buttons and gives them labels
    private void setButtons() {
        // In the load Panel
        loadButton = new JButton("Yes");
        loadNoButton = new JButton("No");
        addButton(loadButton, loadPanel);
        addButton(loadNoButton, loadPanel);

        // In the menu panel
        addButton = new JButton("record food items");
        saveButton = new JButton("save current foodie diary");
        addButton(addButton, menuPanel);
        addButton(saveButton, menuPanel);

        //In the addLeftPanel
        viewButton = new JButton("view current foodie diary");
        //(viewButton,addLeftPanel);; 在addleftP加，否则顺序不对
        addFoodButton = new JButton("add to my diary");
        //addButton(addFoodButton,addLeftPanel); 在addleftP加，否则顺序不对

        returnButton = new JButton("return to main menu");
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

        addButton.addActionListener(this);
        addButton.setActionCommand("record");
        saveButton.addActionListener(this);
        saveButton.setActionCommand("save");

        viewButton.addActionListener(this);
        viewButton.setActionCommand("view");

        addFoodButton.addActionListener(this);
        addFoodButton.setActionCommand("add to my diary");

        returnButton.addActionListener(this);
        returnButton.setActionCommand("return to main menu");
    }


//        initializeMenu();
//        initializeMenuButtons();


    // MODIFIES: this
    // EFFECTS: Creates the panel that displays the main menu
    public void makeMenuPanel() {
        menuPanel = new JPanel();
        menuPanel.setBackground(new Color(229, 204, 255));

        nameLabel = new JLabel();
        nameLabel.setText("Fit-Foodie");
        nameLabel.setVisible(true);
        nameLabel.setFont(new Font("Comic Sans", Font.BOLD, 25));
        nameLabel.setSize(300, 100);
        menuPanel.add(nameLabel);

    }

    public void makeAddPanel() {
        addLeftPanel = new JPanel();
        addLeftPanel.setBackground(new Color(204, 229, 255));
        //addLeftPanel.setPreferredSize(new Dimension(250,500));
        addRightPanel = new JPanel();
        addRightPanel.setBackground(new Color(100, 229, 255));
        addRightPanel.setPreferredSize(new Dimension(250,500));

    }


    @Override
    // EFFECTS: calls the given methods when a certain button is clicked on
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Input new info")) {
            //initializeInputPanel();
        } else if (e.getActionCommand().equals("Load")) {
            loadData();
            initializeMenuPanel();
        } else if (e.getActionCommand().equals("Select food type")) {
            JComboBox cb = (JComboBox) e.getSource();
            String foodType = (String) cb.getSelectedItem();
            //TODO: updateFoodType();
        } else if (e.getActionCommand().equals("record")) {
            initializeAddPanel();
        } else if (e.getActionCommand().equals("view")) {
            //TODO : printDiary();
        } else if (e.getActionCommand().equals("add to my diary")) {
            //TODO: addFoodItem();
        } else if (e.getActionCommand().equals("return to main menu")) {
            initializeMenuPanel();
        }


    }

    // MODIFIES: this
    // EFFECTS: initialize the panel that displays the load option
    public void initializeLoadPanel() {
        loadPanel = new JPanel();
        loadPanel.setBackground(new Color(229,255,204));
        add(loadPanel);
        loadPanel.setPreferredSize(new Dimension(500, 500));
        //menuPanel.setBounds(0,0,250,250);

        welcomeLabel = new JLabel("Welcome to Fit-Foodie!");
        welcomeLabel.setFont(new Font("Comic Sans", Font.BOLD, 25));
//        welcomeLabel.setForeground(new Color(229,255,204));
        welcomeLabel.setSize(300, 100);
        welcomeLabel.setVisible(true);

        JLabel loadLabel = new JLabel("Do you choose to load from history data?");
        loadLabel.setFont(new Font("Comic Sans", Font.BOLD, 20));
        loadLabel.setSize(400,50);
        loadLabel.setVisible(true);
        TitledBorder loadingDataTitle = BorderFactory.createTitledBorder("Loading from Fit-Foodie?");
        //Border loadingDataTitle = BorderFactory.createRaisedBevelBorder();
        loadLabel.setBorder(loadingDataTitle);

        logoLabel = new JLabel();
        logoLabel.setIcon(new ImageIcon("data/logoIcon.png"));
        logoLabel.setPreferredSize(new Dimension(300, 300));

        loadPanel.add(logoLabel);
        loadPanel.add(welcomeLabel);
        loadPanel.add(loadLabel);


    }



    //TODO
    // MODIFIES: this
    // EFFECTS: loads the car listings from json file if it exists,
    // otherwise prints error
    public void loadData() {
    }


    // MODIFIES: this
    // EFFECTS: initialize the panel that displays the menu
    public void initializeMenuPanel() {
        add(menuPanel);
        menuPanel.setPreferredSize(new Dimension(500, 500));
        loadPanel.setVisible(false);
        addLeftPanel.setVisible(false);
        addRightPanel.setVisible(false);


//        nameLabel = new JLabel();
//        nameLabel.setText("Fit-Foodie");
//        nameLabel.setVisible(true);
//        nameLabel.setFont(new Font("Comic Sans", Font.BOLD, 25));
//        nameLabel.setSize(300, 100);
//        menuPanel.add(nameLabel);
        menuPanel.setLayout(new BoxLayout(menuPanel,BoxLayout.Y_AXIS));

        menuPanel.setVisible(true);




    }


    // MODIFIES: this
    // EFFECTS: initialize the panel that displays the add options
    public void initializeAddPanel() {
        initializeAddLeftPanel();

        add(addLeftPanel);
        add(addRightPanel);
        setLayout(new BoxLayout(this.getContentPane(), BoxLayout.X_AXIS));
        //pack();
        loadPanel.setVisible(false);
        menuPanel.setVisible(false);

        textArea = new JTextArea();
        textArea.setEditable(true);
        addRightPanel.add(textArea);


        addLeftPanel.setVisible(true);
        addRightPanel.setVisible(true);
        pack();
    }

    // MODIFIES: this
    // EFFECTS: initialize the panel that displays the add options
    public JPanel initializeAddLeftPanel() {
        String[] foodTypeStrings = {"Fruit", "Vegetable", "Meat", "Dairy",
                "Grains", "Snacks", "Beverage"};
        typeBox = new JComboBox(foodTypeStrings);
        typeBox.setSelectedIndex(0);
        typeBox.addActionListener(this);
        typeBox.setActionCommand("Select food type");
        typeBox.setVisible(true);

        typeAsking = new JLabel("PLease select from the food types provided:");
        typeAsking.setFont((new Font("Comic Sans", Font.BOLD, 12)));

        foodAsking = new JLabel("Please input the food item:");
        foodAsking.setFont((new Font("Comic Sans", Font.BOLD, 12)));

        foodInputField = new JTextField(1);


        addLeftPanel.add(typeAsking);
        addLeftPanel.add(typeBox);
        addLeftPanel.add(foodAsking);
        addLeftPanel.add(foodInputField);
        addLeftPanel.add(addFoodButton);
        addLeftPanel.add(viewButton);
        addLeftPanel.add(returnButton);

        addLeftPanel.setLayout(new BoxLayout(addLeftPanel,BoxLayout.Y_AXIS));

        return addLeftPanel;

    }


}



