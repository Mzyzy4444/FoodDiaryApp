package ui.GUI;

import javax.swing.*;
import java.awt.*;

public class MenuPanel {
    private static JPanel menuPanel;

    public static JPanel menuPanel() {
        menuPanel = new JPanel();
        menuPanel.setBackground(Color.DARK_GRAY);
        menuPanel.setBounds(0,0,250,250);


        return menuPanel;


    }

}
