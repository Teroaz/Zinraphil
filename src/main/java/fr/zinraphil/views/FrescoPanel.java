package fr.zinraphil.views;

import fr.zinraphil.models.patchwork.Fresco;

import javax.swing.*;
import java.awt.*;

import static fr.zinraphil.views.ZinraphilFrame.IMAGE_SIZE;

public class FrescoPanel extends JPanel {

    private Fresco fresco;

    public FrescoPanel(Fresco fresco) {
        super();
        this.fresco = fresco;
        this.setLayout(null);

        fresco.getImages().forEach((point, image) -> {
            ImagePanel imagePanel = new ImagePanel(image);
            imagePanel.setBackground(new Color((int) (Math.random() * 0x1000000)));
            imagePanel.setBounds(point.getX(), point.getY(), image.getWidth(), image.getHeight());
            add(imagePanel);
        });

    }
}
