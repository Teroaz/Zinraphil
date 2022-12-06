package fr.zinraphil.views.fresco;

import fr.zinraphil.controllers.ImageController;
import fr.zinraphil.models.geometry.IDrawable;
import fr.zinraphil.models.geometry.Shape;
import fr.zinraphil.models.patchwork.Image;

import javax.swing.*;
import java.awt.*;

import static fr.zinraphil.controllers.ZinraphilController.IMAGE_SIZE;

public class ImagePanel extends JPanel {

    private final Image image;

    public ImagePanel(Image image) {
        super();
        this.image = image;
        this.setSize(image.getWidth(), image.getHeight());
        this.setBackground(new Color((int) (Math.random() * 0x1000000)));
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        drawReperes(g);

        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setStroke(new BasicStroke(2));

        for (Shape shape : image.getShapes()) {
            Color color = new Color(shape.hashCode() & 0x00FFFFFF);
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

    private void drawReperes(Graphics g) {
        g.setColor(Color.GRAY);
        g.drawLine(0, IMAGE_SIZE / 2, IMAGE_SIZE, IMAGE_SIZE / 2);
        g.drawLine(IMAGE_SIZE / 2, 0, IMAGE_SIZE / 2, IMAGE_SIZE);
    }

    public Image getImage() {
        return image;
    }

    @Override
    public String toString() {
        return "ImagePanel{" +
                "image=" + image +
                '}';
    }
}
