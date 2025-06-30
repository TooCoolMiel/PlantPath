package ui.pages;

import javax.swing.*;
import java.awt.*;

/** Panel class where rendering and setup is handled
 *  Contains all other page panels.
 *  You shouldn't have to make more than one instance of this class.
 */

public class AppPanel extends JPanel {

    /*
        PAGES:

            [0]title
            [1]checkPlants
     */
    // Layout allows us to go to different pages
    private final CardLayout cardLayout;

    public AppPanel(int width, int height) {
        setPreferredSize(new Dimension(width, height));
        setDoubleBuffered(true);
        setFocusable(true);
        requestFocus();
        cardLayout = new CardLayout();
        setLayout(cardLayout);

        new TitlePage(this);
        new PlantStatusPage(this);

        switchToPage("title");
    }




    /**
     * Switches to a page
     * @param page_name the page to switch to
     */
    public void switchToPage(String page_name) {
        cardLayout.show(this, page_name);
    }
}
