package fr.zinraphil.views.control;

import fr.zinraphil.controllers.ImageController;
import fr.zinraphil.models.geometry.Polygon;
import fr.zinraphil.models.geometry.Shape;
import fr.zinraphil.models.geometry.*;
import fr.zinraphil.models.geometry.angle.Angle;
import fr.zinraphil.models.geometry.angle.AngleType;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class ControlPanel extends JPanel {

    private final JLabel selectAnImageLabel;
    private final JPanel transformationsPanel;
    private final JPanel shapesPanel;

    private final JTable table;

    private DefaultTableModel shapesListModel;


    public ControlPanel() {
        super();

        JLabel label = new JLabel("Panneau de controle");
        label.setFont(label.getFont().deriveFont(60f));
        this.add(label);

        selectAnImageLabel = new JLabel("Selectionnez une image");
        selectAnImageLabel.setFont(selectAnImageLabel.getFont().deriveFont(30f));
        this.add(selectAnImageLabel);

        shapesPanel = new JPanel();

        String[] shapes = {"Cercle", "Ellipse", "Ligne", "Polygone"};
        Arrays.stream(shapes).map(JButton::new).forEach(button -> {
            button.setPreferredSize(new Dimension(200, 100));
            button.setFont(button.getFont().deriveFont(20f));
            button.addActionListener(e -> onShapeClick(button));
            shapesPanel.add(button);
        });

        shapesPanel.setVisible(false);
        this.add(shapesPanel);

        transformationsPanel = new JPanel();
        String[] transformations = {"Rotation", "Translation", "Sym. axiale", "Sym. centrale", "Homothétie"};
        Arrays.stream(transformations).map(JButton::new).forEach(button -> {
            button.setPreferredSize(new Dimension(160, 100));
            button.setFont(button.getFont().deriveFont(16f));
            button.addActionListener(e -> onTransformationClick(button));
            transformationsPanel.add(button);
        });

        transformationsPanel.setVisible(false);
        this.add(transformationsPanel);

        table = new JTable();
        shapesListModel = new DefaultTableModel();
        table.setModel(shapesListModel);
        table.setVisible(false);

        this.add(table);
    }

    private void onTransformationClick(JButton button) {

        System.out.println("[OnTransformationClick] Click on " + button.getText());

        List shapes = ImageController.getInstance().getCurrentImagePanel().getImage().getShapes().stream().toList();
        switch (button.getText()) {
            case "Rotation":
                Angle angle = new Angle(AngleType.DEGREE, 90);
                shapes.stream().filter(shape -> shape instanceof IRotation).forEach(shape -> ((IRotation) shape).rotation(angle));
                break;
            case "Translation":
                shapes.stream().filter(shape -> shape instanceof ITranslation).forEach(shape -> ((ITranslation) shape).translation(10, 10));
                break;
            case "Symétrie axiale":
                shapes.stream().filter(shape -> shape instanceof Isymetrieaxiale).forEach(shape -> ((Isymetrieaxiale) shape).symetrieaxiale());
                break;
            case "Symétrie centrale":
                shapes.stream().filter(shape -> shape instanceof Isymetriecentrale).forEach(shape -> ((Isymetriecentrale) shape).symetriecentrale());
                break;
            case "Homothétie":
                // TODO Implement this transformation
//                shapes.stream().filter(shape -> shape instanceof Ihomothety).forEach(shape -> ((Ihomothety) shape).homothetie(2));
                break;
        }


    }

    private void onShapeClick(JButton button) {

        System.out.println("[OnShapeClick] Click on " + button.getText());

        Shape shape = switch (button.getText()) {
            case "Cercle" -> ShapeFactory.generateShape(Circle.class);
            case "Ligne" -> ShapeFactory.generateShape(Line.class);
            case "Ellipse" -> ShapeFactory.generateShape(Ellipsis.class);
            case "Polygone" -> ShapeFactory.generateShape(Polygon.class);
            default -> throw new IllegalStateException("Unexpected value: " + button.getText());
        };

        if (shape != null) {
            boolean isNewToImage = ImageController.getInstance().getCurrentImagePanel().getImage().addShape(shape);
            if (!isNewToImage) {
                JOptionPane.showMessageDialog(this, "La forme à insérer est déjà présente dans l'image. Tentative avec de nouvelles valeurs", "Erreur", JOptionPane.ERROR_MESSAGE);
                this.onShapeClick(button);
            }
        }

        this.updateUI();
    }

    @Override
    public void updateUI() {
        super.updateUI();
        if (selectAnImageLabel == null) return;

        if (ImageController.getInstance().getCurrentImagePanel() == null) {
            selectAnImageLabel.setVisible(true);
            shapesPanel.setVisible(false);
            transformationsPanel.setVisible(false);
            table.setVisible(false);
        } else {
            selectAnImageLabel.setVisible(false);
            shapesPanel.setVisible(true);
            transformationsPanel.setVisible(true);
            table.setVisible(true);
        }

    }

}

