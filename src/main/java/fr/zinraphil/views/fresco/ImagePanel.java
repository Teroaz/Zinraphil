package fr.zinraphil.views.fresco;

import fr.zinraphil.models.geometry.IDrawable;
import fr.zinraphil.models.patchwork.Image;

import javax.swing.*;
import java.awt.*;

import static fr.zinraphil.controllers.ZinraphilController.IMAGE_SIZE;

public class ImagePanel extends JPanel {

    private Image image;

    public ImagePanel(Image image) {
        super();
        this.image = image;
        this.setSize(image.getWidth(), image.getHeight());
        this.setBackground(new Color((int) (Math.random() * 0x1000000)));

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        image.getShapes().stream().filter(s -> s instanceof IDrawable).forEach(s -> ((IDrawable) s).draw(g));
    }

    private void drawReperes(Graphics g) {
        g.setColor(Color.GRAY);
        g.drawLine(0, IMAGE_SIZE / 2, IMAGE_SIZE, IMAGE_SIZE / 2);
        g.drawLine(IMAGE_SIZE / 2, 0, IMAGE_SIZE / 2, IMAGE_SIZE);
    }

    public void onClick() {
        System.out.println("click" + this);
    }
}
