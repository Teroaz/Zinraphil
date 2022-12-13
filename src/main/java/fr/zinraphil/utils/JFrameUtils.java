package fr.zinraphil.utils;

import fr.zinraphil.models.geometry.Point;

import javax.swing.*;
import java.awt.*;

/**
 * Provides utility methods for working with {@link JFrame} objects.
 */
public class JFrameUtils {

    /**
     * Returns the coordinates at which a frame of the specified size should be centered on the screen.
     *
     * @param width  The width of the frame.
     * @param height The height of the frame.
     * @return The coordinates at which the frame should be centered on the screen.
     */
    public static Point centerFrameCoords(int width, int height) {
        GraphicsDevice ge = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        int screenWidth = ge.getDisplayMode().getWidth();
        int screenHeight = ge.getDisplayMode().getHeight() - 50;

        return new Point((screenWidth - width) / 2, (screenHeight - height) / 2);
    }


}
