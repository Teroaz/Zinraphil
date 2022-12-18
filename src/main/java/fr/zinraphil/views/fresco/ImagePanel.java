package fr.zinraphil.views.fresco;

import fr.zinraphil.controllers.ImageController;
import fr.zinraphil.models.geometry.IDrawable;
import fr.zinraphil.models.geometry.Shape;
import fr.zinraphil.models.patchwork.Image;

import javax.swing.*;
import java.awt.*;

import static fr.zinraphil.controllers.ZinraphilController.IMAGE_SIZE;

/**
 * Represents a panel that displays an image.
 */
public class ImagePanel extends JPanel {
    private final Image image;

    /**
     * Constructs a new ImagePanel with the specified image.
     *
     * @param image The image to be displayed by the panel with a random background color.
     */
    public ImagePanel(Image image) {
        super();
        this.image = image;

        this.setSize(image.getWidth(), image.getHeight());
        this.setBackground(new Color((int) (Math.random() * 0x1000000)));

        System.out.println("> Instantiating ImagePanel at size : " + image.getWidth() + "x" + image.getHeight() + " with given image : " + image);
    }

    /**
     * Paints the panel and its components.
     *
     * @param g The graphics context to use for painting.
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);

        drawReperes(g);

        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setStroke(new BasicStroke(2));

        for (Shape shape : image.getShapes()) {
            Color color = new Color(shape.hashCode() & 0x00FFFFFF);
            float hue = Color.RGBtoHSB(color.getRed(), color.getGreen(), color.getBlue(), null)[0];
            color = new Color(Color.HSBtoRGB(hue, 0.45f, 0.65f));
            g2.setColor(color);

            if (shape instanceof IDrawable) {
                ((IDrawable) shape).draw(g2);
            }
        }

        g2.setColor(Color.BLACK);

        if (this != ImageController.getInstance().getCurrentImagePanel()) {
            this.setBorder(null);
            return;
        }

        this.setBorder(BorderFactory.createLineBorder(Color.RED, 5));
    }

    /**
     * Draws two lines on the image, one horizontal and one vertical,
     * passing through the center of the image.
     * The lines are drawn in gray color.
     *
     * @param g the graphics object to use for drawing the lines
     */
    private void drawReperes(Graphics g) {
        g.setColor(Color.GRAY);
        g.drawLine(0, IMAGE_SIZE / 2, IMAGE_SIZE, IMAGE_SIZE / 2);
        g.drawLine(IMAGE_SIZE / 2, 0, IMAGE_SIZE / 2, IMAGE_SIZE);
    }

    /**
     * Returns the image contained in this panel.
     *
     * @return the image contained in this panel
     */
    public Image getImage() {
        return image;
    }

    /**
     * Returns a string representation of this ImagePanel object.
     * The string contains the string representation of the image contained in this panel.
     *
     * @return a string representation of this ImagePanel object
     */
    @Override
    public String toString() {
        return "ImagePanel{" +
                "image=" + image +
                '}';
    }

}
