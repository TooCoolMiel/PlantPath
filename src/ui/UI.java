package ui;

// old is gold
import io.IO;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;

/** Class handles all the UI stuff
   The AppPanel really handle stuff like rendering, however the handles windowing and
   connects UI elements together.
   You shouldn't have to make more than one instance of this class.
*/
public class UI {

    // The main frame, not really much to say
    private final JFrame main_frame;

    // Constructs it and sets up everything with provided settings
    public UI(String screenTitle, int screenWidth, int screenHeight) {
        // creates a frame with the title and some default settings like a title
        // and centering everything else is self-explanatory
        main_frame = new JFrame(screenTitle);
        main_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension monitorDimensions = Toolkit.getDefaultToolkit().getScreenSize();
        main_frame.setLocation((monitorDimensions.width - screenWidth) / 2, (monitorDimensions.height - screenHeight) / 2);

        try {
            main_frame.setIconImage(IO.loadImage("PlantPathIcon.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        AppPanel main_app_panel = new AppPanel(screenWidth, screenHeight);
        main_frame.add(main_app_panel);

        // make the frame the same size as the panel and make it visible
        main_frame.pack();
        main_frame.setVisible(true);
    }
}

/** Panel class where rendering is handled
 *
 */
class AppPanel extends JPanel {
    public AppPanel(int width, int height) {
        setPreferredSize(new Dimension(width, height));
        setDoubleBuffered(true);
        setFocusable(true);
        requestFocus();
        setLayout(null);
    }


}

