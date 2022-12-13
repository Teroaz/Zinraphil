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
        String shape = (String) value;
        setText(shape);
        System.out.println("need to render " + shape);
        return this;
    }
}
