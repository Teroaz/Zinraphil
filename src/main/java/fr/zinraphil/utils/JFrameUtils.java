package fr.zinraphil.utils;

import fr.zinraphil.models.geometry.Point;

import java.awt.*;

public class JFrameUtils {

    /**
     * @param width  La largeur de la fenêtre
     * @param height La hauteur de la fenêtre
     * @return Les coordonnées pour placer la fenêtre au centre de l'écran
     */
    public static Point centerFrameCoords(int width, int height) {
        GraphicsDevice ge = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        int screenWidth = ge.getDisplayMode().getWidth();
        int screenHeight = ge.getDisplayMode().getHeight();

        return new Point((screenWidth - width) / 2, (screenHeight - height) / 2);
    }


}
