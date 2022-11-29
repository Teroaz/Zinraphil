
package fr.zinraphil.views.fresco;

import fr.zinraphil.controllers.ImageController;
import fr.zinraphil.models.patchwork.Fresco;

import javax.swing.*;
import java.util.ArrayList;

public class FrescoPanel extends JPanel {

    private Fresco fresco;

    private ArrayList<ImagePanel> imagePanels = new ArrayList<>();

    public FrescoPanel(Fresco fresco) {
        super();
        this.setLayout(null);

        this.fresco = fresco;

        fresco.getImages().forEach((point, image) -> {
            ImagePanel imagePanel = new ImagePanel(image);
            imagePanel.addMouseListener(ImageController.getInstance());
            imagePanel.setLocation(point.getX(), point.getY());
            this.imagePanels.add(imagePanel);
        });

//        this.addMouseListener();
        this.imagePanels.forEach(this::add);
    }

    public Fresco getFresco() {
        return fresco;
    }

    public ArrayList<ImagePanel> getImagePanels() {
        return imagePanels;
    }
}
