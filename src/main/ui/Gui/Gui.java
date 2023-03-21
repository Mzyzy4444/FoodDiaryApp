package ui.Gui;

import javax.swing.*;
import javax.swing.ImageIcon;
import java.awt.*;

public class Gui extends JFrame {

    // Make a new JFrame with different attributes
    public Gui() {
        super(" Food Diary App");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(true);
        this.setSize(500,500);
        this.getContentPane().setBackground(new Color(229,255,204));


        JLabel welcomeLabel = new JLabel("Welcome to Fit-Foodie!");
//        ImageIcon welcomeIcon = new ImageIcon("image.png");
//        welcomeLabel.setIcon(welcomeIcon);
//        welcomeLabel.setMinimumSize(new Dimension(20,20));
//        welcomeLabel.setHorizontalTextPosition(JLabel.CENTER);
        welcomeLabel.setFont(new Font("ComicSans",Font.BOLD,30));
        //welcomeLabel.setIconTextGap(50);
        //JLabel mainScreenImage = new JLabel();
        //addImageToLabel(mainScreenImage);
        this.add(welcomeLabel);



    }

//    public void addImageToLabel(JLabel j1) {
//        j1.setIcon(new ImageIcon("welcomeIcon.jpeg"));
//        j1.setMinimumSize(new Dimension(20,20));
//        mainMenu.add(j1);
//    }


}
