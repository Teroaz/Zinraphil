package fr.zinraphil.views;

import fr.zinraphil.models.patchwork.Image;

import javax.swing.*;
import java.awt.*;

public class ImagePanel extends JPanel {

    public ImagePanel(Image image) {
        super();

        this.setBackground(new Color((int) (Math.random() * 0x1000000)));
    }
}
