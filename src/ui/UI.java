package ui;

// old is gold
import io.IO;
import ui.pages.AppPanel;

import javax.swing.*;
import java.awt.*;


/** Class handles all the UI stuff
   The AppPanel really handles stuff like rendering, however UI handles windowing and
   connects UI elements together.
   You shouldn't have to make more than one instance of this class.
*/
public class UI {

    // Constructs it and sets up everything with provided settings
    public UI(String screenTitle, int screenWidth, int screenHeight) {
        // creates a frame with the title and some default settings like a title
        // and centering everything else is self-explanatory
        // The main frame, not really much to say
        JFrame main_frame = new JFrame(screenTitle);
        main_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension monitorDimensions = Toolkit.getDefaultToolkit().getScreenSize();
        main_frame.setLocation((monitorDimensions.width - screenWidth) / 2, (monitorDimensions.height - screenHeight) / 2);

        try {
            main_frame.setIconImage(IO.loadImage("PlantPathIcon.png"));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Failed to load icon image: " + e);
        }

        AppPanel main_app_panel = new AppPanel(screenWidth, screenHeight);
        main_frame.add(main_app_panel);

        // make the frame the same size as the panel and make it visible
        main_frame.pack();
        main_frame.setVisible(true);
    }
}


