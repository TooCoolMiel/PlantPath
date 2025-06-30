package io;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class IO {
    /**
     *  provides path such as res/ is already included.
     *  For example, res/image.jpg, you would only need to provide "image.jpg".
     * @param path path relative to the res folder
     * @return the image
     * @throws Exception exception in case of input errors
     */
    public static BufferedImage loadImage(String path) throws Exception {
        return ImageIO.read(IO.class.getResourceAsStream("/res/" + path));
    }
}
