package fr.zinraphil.views.control;

import javax.swing.*;
import java.awt.*;

public class JTableShape extends JTable {

    private ModelShape modelShape;
    private final JScrollPane scrollPane;

    public JTableShape(ModelShape modelShape) {
        super(modelShape);

        this.modelShape = modelShape;

        scrollPane = new JScrollPane(this, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        scrollPane.setPreferredSize(new Dimension(440, 380));

        getTableHeader().setReorderingAllowed(false);
        setRowHeight(30);

        setDefaultRenderer(String.class, new ShapeRenderer());
        setDefaultRenderer(Double.class, new ShapeRenderer());
    }

    public ModelShape getModelShape() {
        return modelShape;
    }

    public JScrollPane getScrollPane() {
        return scrollPane;
    }
}
