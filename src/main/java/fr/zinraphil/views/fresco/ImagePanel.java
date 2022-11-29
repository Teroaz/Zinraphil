package fr.zinraphil.views.fresco;

import fr.zinraphil.models.geometry.IDrawable;
import fr.zinraphil.models.geometry.Shape;
import fr.zinraphil.models.patchwork.Image;

import javax.swing.*;
import java.awt.*;

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

    public void onClick() {
        System.out.println("click" + this);
    }
}
