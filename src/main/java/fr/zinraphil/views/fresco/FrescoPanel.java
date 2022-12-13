
package fr.zinraphil.views.fresco;

import fr.zinraphil.controllers.ImageController;
import fr.zinraphil.models.patchwork.Fresco;

import javax.swing.*;
import java.util.ArrayList;

/**
 * This class represents a panel that displays a {@link Fresco} object.
 * <p>
 * The panel is populated with {@link ImagePanel} objects that represent the individual images in the fresco.
 * <p>
 * The {@link ImageController} is registered as a mouse listener and motion listener for each image panel.
 */
public class FrescoPanel extends JPanel {

    private final Fresco fresco;

    private final ArrayList<ImagePanel> imagePanels = new ArrayList<>();

    /**
     * Constructs a new {@code FrescoPanel} with the specified {@link Fresco} object.
     *
     * @param fresco the {@link Fresco} object to display in the panel
     */
    public FrescoPanel(Fresco fresco) {
        super();
        this.setLayout(null);

        this.fresco = fresco;

        fresco.getImages().forEach((point, image) -> {
            ImagePanel imagePanel = new ImagePanel(image);
            imagePanel.addMouseListener(ImageController.getInstance());
            imagePanel.addMouseMotionListener(ImageController.getInstance());
            imagePanel.setLocation(point.getX(), point.getY());
            this.imagePanels.add(imagePanel);
        });

        this.imagePanels.forEach(this::add);
    }

    /**
     * Returns the {@link Fresco} object associated with this panel.
     *
     * @return the {@link Fresco} object associated with this panel
     */
    public Fresco getFresco() {
        return fresco;
    }

    /**
     * Returns the list of ImagePanels in this object.
     *
     * @return the list of ImagePanels in this object
     */
    public ArrayList<ImagePanel> getImagePanels() {
        return imagePanels;
    }
}
