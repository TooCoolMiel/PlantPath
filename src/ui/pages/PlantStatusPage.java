package ui.pages;

import settings.Constants;
import ui.elements.AppButton;

import javax.swing.*;
import java.awt.*;

public class PlantStatusPage extends JPanel {
    public PlantStatusPage(AppPanel parent) {
        // Give the checkPlant panel the same dimensions as the App Panel
        setPreferredSize(new Dimension(parent.getWidth(), parent.getHeight()));
        setBackground(Color.GREEN);
        setDoubleBuffered(true);
        setFocusable(true);
        requestFocus();
        setLayout(null);
        setBackground(Constants.theme_color);

        JLabel title = new JLabel("Plant Status Page");
        title.setFont(Constants.text_font);
        title.setBounds(0,0,600,80);
        title.setForeground(Color.BLACK);
        add(title);

        // Temporarily we won't provide an image
        AppButton button = new AppButton("Back");
        button.giveFunction(_->parent.switchToPage("title"));
        button.setBounds(10, 200, 100, 50);
        add(button);

        parent.add(this, "checkPlants");
    }
}
