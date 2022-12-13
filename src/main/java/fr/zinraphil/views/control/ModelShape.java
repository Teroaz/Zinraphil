package fr.zinraphil.views.control;

import fr.zinraphil.models.geometry.Shape;

import javax.swing.table.DefaultTableModel;
import java.util.TreeSet;

public class ModelShape extends DefaultTableModel {

    private static final String[] COLUMN_NAMES = {"Type", "Aire", "Périmètre"};
    private TreeSet<Shape> shapes = new TreeSet<>();

    public ModelShape() {
        setColumnCount(COLUMN_NAMES.length);
        setColumnIdentifiers(COLUMN_NAMES);
    }

    public void setShapes(TreeSet<Shape> shapes) {
        this.shapes = shapes;
        setRowCount(shapes.size());



        setValueAt("test", 1, 1);
    }

    public static String[] getColumnNames() {
        return COLUMN_NAMES;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == 1 || columnIndex == 2) {
            return Double.class;
        }
        return String.class;
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }
}
