package ui.elements;

import io.IO;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;

public class AppButton extends JButton {


    // Images for when the button is hovered and unhovered over
    private ImageIcon checkPlants_button_unhovered = null;
    private ImageIcon checkPlants_button_hovered = null;

    public AppButton(String text) {
        super(text);
    }

    public AppButton(String unhovered_image_path, String default_text) {
        try {
            final BufferedImage buttonImage = IO.loadImage(unhovered_image_path);

            // Image editing tool
            final RescaleOp op = new RescaleOp(1.2f, 0.0f, null);

            // Make the original image brighter for the hovered over effect
            checkPlants_button_hovered = new ImageIcon(op.filter(buttonImage, null));
            checkPlants_button_unhovered = new ImageIcon(buttonImage);

            changeImage(false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Failed to load button image: " + e);
            setText(default_text);
        }
    }

    /**
     *
     * Gives a button functionality.
     * [Lambda template: e -> System.out.println("Button pressed!");]
     *
     * @param function the function to add to the button. Ideally would pass this as a lambda.
     */
    public void giveFunction(ActionListener function) {
        addActionListener(function);
    }

    /**
     * Changes the button's image.
     */
    public void changeImage(boolean hovered) {
        if (checkPlants_button_hovered == null || checkPlants_button_unhovered == null) return;

        setIcon(
                hovered ? checkPlants_button_hovered : checkPlants_button_unhovered
        );
    }
}

