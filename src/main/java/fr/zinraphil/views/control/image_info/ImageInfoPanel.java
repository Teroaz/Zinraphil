package fr.zinraphil.views.control.image_info;

import fr.zinraphil.models.geometry.Shape;
import fr.zinraphil.models.patchwork.Image;

import javax.swing.*;

public class ImageInfoPanel extends JPanel {
    public ImageInfoPanel(Image image) {
        super();
        this.setBorder(BorderFactory.createTitledBorder("Image info"));

        DefaultListModel<Shape> model = new DefaultListModel<>();

        image.getShapes().forEach(model::addElement);

        JList<Shape> list = new JList<>(model);
        list.setCellRenderer(new ShapeRenderer());
    }

}
