package fr.zinraphil.views.control.image_info;

import fr.zinraphil.models.geometry.Shape;

import javax.swing.*;
import java.awt.*;

public class ShapeRenderer extends JPanel implements ListCellRenderer<Shape> {

    @Override
    public Component getListCellRendererComponent(JList<? extends Shape> list, Shape value, int index, boolean isSelected, boolean cellHasFocus) {
        return value.area() > 0 ? new JLabel(value.toString()) : new JLabel("Empty shape");
    }

    public ShapeRenderer() {
        super();
    }


}
