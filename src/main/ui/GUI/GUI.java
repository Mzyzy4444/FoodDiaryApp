package ui.GUI;


import model.FoodDiary;
import model.FoodItem;
import org.json.JSONObject;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import static java.lang.Integer.parseInt;

public class GUI extends JFrame implements ActionListener {
    private FoodDiary fd;
    private FoodItem foodItem;
    private FoodItem.FoodType foodType;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    private JPanel loadPanel;
    private JPanel menuPanel;
    private JPanel addLeftPanel;
    private JPanel addRightPanel;
    private JPanel InputPanel;

    private JButton returnButton;
    private JButton loadButton;
    private JButton loadNoButton;
    private JButton addButton;
    private JButton saveButton;
    private JButton viewButton;
    private JButton addFoodButton;

    private JButton add2Button;


    private JComboBox typeBox;

    private JTextArea textArea;
    private JTextField foodInputField;
    private JTextField nameT;
    private JTextField weightT;
    private JTextField heightT;
    private JTextField ageT;
    private JTextField sexT;

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
        setButtons();
        makeAddPanel();

        addActionToButton();
        initializeInputPanel();


        this.setVisible(true);
        loadPanel.setVisible(true);
        menuPanel.setVisible(false);
        addRightPanel.setVisible(false);
        addLeftPanel.setVisible(false);

        InputPanel.setVisible(false);

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

        add2Button = new JButton("add new fd to json");
    }

    // MODIFIES: this
    // EFFECTS: adds buttons to loadMenu
    public void addButton(JButton button1, JPanel panel) {
        button1.setFont(new Font("Comic Sans", Font.BOLD, 12));
        button1.setBackground(Color.white);
        panel.add(button1);
        //pack();
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

        add2Button.addActionListener(this);
        add2Button.setActionCommand("add new info to json");

    }


//        initializeMenu();
//        initializeMenuButtons();


    // MODIFIES: this
    // EFFECTS: Creates the panel that displays the main menu
    public void makeMenuPanel() {
        menuPanel = new JPanel();
        menuPanel.setBackground(new Color(229, 204, 255));
        menuPanel.setPreferredSize(new Dimension(500,500));
        menuPanel.setMaximumSize(menuPanel.getPreferredSize());
        menuPanel.setMinimumSize(menuPanel.getPreferredSize());


        nameLabel = new JLabel();
        nameLabel.setText("Fit-Foodie");
        nameLabel.setVisible(true);
        nameLabel.setFont(new Font("Comic Sans", Font.BOLD, 25));
        nameLabel.setSize(300, 100);
        menuPanel.add(nameLabel);
        menuPanel.add(logoLabel);
        pack();


    }

    // MODIFIES: this
    // EFFECTS: make two add panels and add to the JFrame
    public void makeAddPanel() {
        addLeftPanel = new JPanel();
        addLeftPanel.setBackground(new Color(204, 229, 255));
        addRightPanel = new JPanel();
        addRightPanel.setBackground(new Color(210, 204, 255));
        addRightPanel.setPreferredSize(new Dimension(250, 500));

        textArea = new JTextArea();
        textArea.setEditable(true);
        addRightPanel.add(textArea);

        add(addLeftPanel);
        add(addRightPanel);

        initializeAddLeftPanel();

    }


    @Override
    // EFFECTS: calls the given methods when a certain button is clicked on
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Input new info")) {
            initializeInputPanel();
            //initializeMenuPanel();
        } else if (e.getActionCommand().equals("Load")) {
            loadData();
            initializeMenuPanel();
        } else if (e.getActionCommand().equals("save")) {
            saveData();
        } else if (e.getActionCommand().equals("record")) {
            initializeAddPanel();
        } else if (e.getActionCommand().equals("view")) {
            printDiary();
        } else if (e.getActionCommand().equals("add to my diary")) {
            addFoodItem();
        } else if (e.getActionCommand().equals("return to main menu")) {
            initializeMenuPanel();
        } else if (e.getActionCommand().equals("add new info to json")) {
            //saveData2(fd);
            setInfo();
            initializeAddPanel();
        }
    }

    // MODIFIES: this
    // EFFECTS: initialize input panel;
    public void initializeInputPanel() {
        InputPanel = new JPanel();
        InputPanel.setBackground(new Color(229, 255, 204));
        InputPanel.setPreferredSize(new Dimension(500, 500));
        JLabel infoAskingLabel = new JLabel("Please input your information to create a customized foodie diary");

        nameT = new JTextField();
        nameT.setEditable(true);
        nameT.setBorder(new TitledBorder("input your name:"));

        weightT = new JTextField();
        weightT.setEditable(true);
        weightT.setBorder(new TitledBorder("input your weight in Kg:"));

        heightT = new JTextField();
        heightT.setEditable(true);
        heightT.setBorder(new TitledBorder("input your height in cm:"));

        ageT = new JTextField();
        ageT.setEditable(true);
        ageT.setBorder(new TitledBorder("input your age:"));

        sexT = new JTextField();
        sexT.setEditable(true);
        sexT.setBorder(new TitledBorder("input your gender(male or female):"));



        InputPanel.add(infoAskingLabel);
        inputPAddCs();
//        InputPanel.add(nameT);
//        InputPanel.add(weightT);
//        InputPanel.add(heightT);
//        InputPanel.add(ageT);
//        InputPanel.add(sexT);
//        InputPanel.setLayout(new BoxLayout(InputPanel, BoxLayout.Y_AXIS));
//        InputPanel.add(add2Button);


//        InputPanel.setVisible(true);
//        loadPanel.setVisible(false);
//        addLeftPanel.setVisible(false);
//        addRightPanel.setVisible(false);
//        menuPanel.setVisible(false);


        add(InputPanel);
    }

    //MODIFIES: inputPanel
    // EFFECTS: add all the components needed to input panel and set only inputPanel to be visible
    public void inputPAddCs() {
        //InputPanel.add(infoAskingLabel);
        InputPanel.add(nameT);
        InputPanel.add(weightT);
        InputPanel.add(heightT);
        InputPanel.add(ageT);
        InputPanel.add(sexT);
        InputPanel.setLayout(new BoxLayout(InputPanel, BoxLayout.Y_AXIS));
        InputPanel.add(add2Button);

        InputPanel.setVisible(true);
        loadPanel.setVisible(false);
        addLeftPanel.setVisible(false);
        addRightPanel.setVisible(false);
        menuPanel.setVisible(false);
    }



    // MODIFIES: fd
    // EFFECTS: input user info to the newly-constructed food diary and save new user info to json;
    public void setInfo() {
        try {
            String userName = (String) nameT.getText();
            int userWeight = parseInt(weightT.getText());
            int userHeight = parseInt(heightT.getText());
            int userAge = parseInt(ageT.getText());
            String userSex = (String) sexT.getText();

            this.fd = new FoodDiary(userName, userWeight, userHeight, userAge, userSex);
            jsonWriter = new JsonWriter("data/food-diary.json");
            jsonWriter.open();
            jsonWriter.write(fd);
            jsonWriter.close();

        } catch (NumberFormatException e) {
            // catched;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }



    // MODIFIES: this
    // EFFECTS: initialize the panel that displays the load option
    public void initializeLoadPanel() {
        loadPanel = new JPanel();
        loadPanel.setBackground(new Color(229, 255, 204));
        loadPanel.setPreferredSize(new Dimension(500, 500));
        //menuPanel.setBounds(0,0,250,250);

        welcomeLabel = new JLabel("Welcome to Fit-Foodie!");
        welcomeLabel.setFont(new Font("Comic Sans", Font.BOLD, 25));
        welcomeLabel.setSize(300, 100);
        welcomeLabel.setVisible(true);

        JLabel loadLabel = new JLabel("Do you choose to load from history data?");
        loadLabel.setFont(new Font("Comic Sans", Font.BOLD, 20));
        loadLabel.setSize(400, 50);
        loadLabel.setVisible(true);
        TitledBorder loadingDataTitle = BorderFactory.createTitledBorder("Loading from Fit-Foodie?");
        //Border loadingDataTitle = BorderFactory.createRaisedBevelBorder();
        loadLabel.setBorder(loadingDataTitle);

        logoLabel = new JLabel();
        logoLabel.setIcon(new ImageIcon("data/logoIcon.png"));
        logoLabel.setPreferredSize(new Dimension(300, 300));


        loadPanel.add(welcomeLabel);
        loadPanel.add(logoLabel);
        loadPanel.add(loadLabel);
        pack();

        add(loadPanel);


    }


    // MODIFIES: this
    // EFFECTS: initialize the panel that displays the menu
    public void initializeMenuPanel() {
        add(menuPanel);
        menuPanel.setPreferredSize(new Dimension(500, 500));
        loadPanel.setVisible(false);
        addLeftPanel.setVisible(false);
        addRightPanel.setVisible(false);
        InputPanel.setVisible(false);

        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));

        menuPanel.setVisible(true);


    }


    // MODIFIES: this
    // EFFECTS: initialize the panel that displays the add options
    public void initializeAddPanel() {
        setLayout(new BoxLayout(this.getContentPane(), BoxLayout.X_AXIS));
        //pack();
        loadPanel.setVisible(false);
        menuPanel.setVisible(false);
        InputPanel.setVisible(false);

        addLeftPanel.setVisible(true);
        addRightPanel.setVisible(true);
        pack();
    }

    // MODIFIES: this
    // EFFECTS: initialize the panel that displays the add options
    public JPanel initializeAddLeftPanel() {
        String[] foodTypeStrings = {"Fruit", "Vegetable", "Meat", "Snacks", "Beverage"};
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

        addLeftPanel.setLayout(new BoxLayout(addLeftPanel, BoxLayout.Y_AXIS));

        return addLeftPanel;

    }

    // MODIFIES : this
    // EFFECTS : Adds the user given food item and food type to food diary
    public void addFoodItem() {
        foodType = getType((String) typeBox.getSelectedItem());
        foodItem = new FoodItem(foodInputField.getText(), foodType);
        fd.addFoodItem(foodItem);
        textArea.setText("Food successfully added ^v^ !");
    }


    // EFFECTS: return food type corresponding to the user input
    public FoodItem.FoodType getType(String type) {
        if (type == "Fruit") {
            foodType = FoodItem.FoodType.FRUIT;
        } else if (type == "Vegetable") {
            foodType = FoodItem.FoodType.VEGETABLE;
        } else if (type == "Meat") {
            foodType = FoodItem.FoodType.MEAT;
        } else if (type == "Snacks") {
            foodType = FoodItem.FoodType.SNACKS;
        } else if (type == "Beverage") {
            foodType = FoodItem.FoodType.BEVERAGES;
        }
        return foodType;
    }

    // EFFECTS: display the food items in current food diary in the addRightPanel
    public void printDiary() {

        textArea.setPreferredSize(new Dimension(200,450));
        textArea.setBackground(new Color(255,204,229));
        textArea.setForeground(new Color(0,0,0));
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        //textArea.setBorder(BorderFactory.createMatteBorder(-1,-1,-1,-1,new ImageIcon("data/waveline.gif")));
        pack();
        try {
            textArea.setText("The food in your diary are:" + fd.printDiaryViewList());
            textArea.setDisabledTextColor(new Color(0,0,0));
            textArea.setSelectedTextColor(new Color(0,0,0));
        } catch (NullPointerException e) {
            textArea.setText("No food diary recorded");
            textArea.setDisabledTextColor(new Color(0,0,0));
            textArea.setSelectedTextColor(new Color(0,0,0));
        }

    }


    // MODIFIES: this
    // EFFECTS: load food diary data from json file
    public void loadData() {
        try {
            jsonReader = new JsonReader("data/food-diary.json");
            fd = jsonReader.read();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    // MODIFIES : this
    // EFFECTS: save current food Diary to json file
    public void saveData() {
        try {
            jsonWriter = new JsonWriter("data/food-diary.json");
            jsonWriter.open();
            jsonWriter.write(fd);
            jsonWriter.close();
            System.out.println("Food Diary saved to file " + "data/food-diary.json");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

//    public void saveData2(FoodDiary fd) {
//        try {
////            JSONObject json = fd.toJson();
////            jsonWriter.saveToFile(json.toString(4));
////            jsonWriter = new JsonWriter("data/food-diary.json");
////            jsonWriter.open();
////            jsonWriter.write(fd);
////            jsonWriter.close();
//            System.out.println("Food Diary saved to file " + "data/food-diary.json");
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }


}



