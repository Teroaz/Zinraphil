package fr.zinraphil.views.control;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class ShapeRenderer extends JLabel implements TableCellRenderer {

    public ShapeRenderer() {
        super();
        setOpaque(true);
        setBackground(Color.WHITE);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

        if (value instanceof String) {
            setText((String) value);
        } else if (value instanceof Double) {
            setText(String.format("%.2f", value));
        }
//        System.out.println("need to render " + shape);
        return this;
    }
}
