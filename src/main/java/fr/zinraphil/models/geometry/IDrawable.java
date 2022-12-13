package fr.zinraphil.models.geometry;

import java.awt.*;

/**
 * Interface for objects that can be drawn to a {@link Graphics} object.
 */
public interface IDrawable {

    /**
     * Draws the object to the given Graphics object.
     *
     * @param g the Graphics object to draw to
     */
    void draw(Graphics g);
}
