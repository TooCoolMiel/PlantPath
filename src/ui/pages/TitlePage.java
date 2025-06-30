package ui.pages;

import settings.Constants;
import ui.elements.AppButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TitlePage extends JPanel {
    public TitlePage(AppPanel parent) {
        // Give the title panel the same dimensions as the App Panel
        setPreferredSize(new Dimension(getWidth(), getHeight()));
        setBackground(Constants.theme_color);
        setDoubleBuffered(true);
        setFocusable(true);
        requestFocus();
        setLayout(null);

        // Add title
        final JLabel title = new JLabel("PlantPath v1.0");
        title.setFont(Constants.text_font);
        title.setForeground(Color.BLACK);
        add(title);
        title.setBounds(10,0,500,80);


        final AppButton checkPlants_button = getCheckPlantsButton(parent);

        add(checkPlants_button);

        parent.add(this, "title");
    }

    private AppButton getCheckPlantsButton(AppPanel parent) {
        final AppButton checkPlants_button = new AppButton(Constants.checkPlants_title_button_path, "Check your plants");

        checkPlants_button.setBounds(20, 200, 450, 60);
        checkPlants_button.setBorderPainted(false);

        checkPlants_button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                checkPlants_button.changeImage(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                checkPlants_button.changeImage(false);
            }
        });

        checkPlants_button.giveFunction(_-> parent.switchToPage("checkPlants"));
        return checkPlants_button;
    }
}
