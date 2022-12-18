package fr.zinraphil.views.control;

import fr.zinraphil.controllers.FrescoController;
import fr.zinraphil.controllers.ImageController;
import fr.zinraphil.models.geometry.Point;
import fr.zinraphil.models.geometry.Polygon;
import fr.zinraphil.models.geometry.Shape;
import fr.zinraphil.models.geometry.*;
import fr.zinraphil.models.geometry.angle.Angle;
import fr.zinraphil.models.geometry.angle.AngleType;
import fr.zinraphil.models.patchwork.Fresco;
import fr.zinraphil.models.patchwork.Image;
import fr.zinraphil.models.transformations.*;
import fr.zinraphil.views.fresco.ImagePanel;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ControlPanel extends JPanel {

    private final JLabel selectAnImageLabel;
    private final JPanel transformationsPanel;
    private final JPanel shapesPanel;

    private final JTableShape table;


    public ControlPanel() {
        super();

        System.out.println("> Instantiating ControlPanel");
        JLabel label = new JLabel("Panneau de controle");
        label.setFont(label.getFont().deriveFont(60f));
        this.add(label);

        selectAnImageLabel = new JLabel("Selectionnez une image");
        selectAnImageLabel.setFont(selectAnImageLabel.getFont().deriveFont(30f));
        this.add(selectAnImageLabel);

        System.out.println("[ControlPanel] Adding shapes panel");
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

        System.out.println("[ControlPanel] Adding transformations panel");
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

        System.out.println("[ControlPanel] Adding table panel");
        table = new JTableShape(new ModelShape());
        table.setAutoCreateRowSorter(true);
        table.getScrollPane().setVisible(false);
        this.add(table.getScrollPane());
    }

    private void onTransformationClick(JButton button) {

        System.out.println("[ControlPanel] TransformationClick on " + button.getText());

        Image selectedImage = ImageController.getInstance().getCurrentImagePanel().getImage();
        List<Shape> shapes = selectedImage.getShapes().stream().toList();

        System.out.println("[ControlPanel] " + shapes.size() + " shapes in current image but not all of them will be transformed !");

        switch (button.getText()) {
            case "Rotation":
                shapes = shapes.stream().filter(shape -> shape instanceof IRotation).toList();

                Angle angle = new Angle(AngleType.DEGREE, new Random().nextInt(360));

                System.out.println("[ControlPanel] Rotation of " + angle.getDegree() + "° on " + shapes.size() + " shapes");
                shapes.forEach(shape -> ((IRotation) shape).applyRotation(angle));
                break;
            case "Translation":
                shapes = shapes.stream().filter(shape -> shape instanceof ITranslation).toList();
                int deltaX = new Random().nextInt(-20, 20);
                int deltaY = new Random().nextInt(-20, 20);

                System.out.println("[ControlPanel] Translation of (" + deltaX + ", " + deltaY + ") on " + shapes.size() + " shapes");
                shapes.forEach(shape -> ((ITranslation) shape).applyTranslation(deltaX, deltaY));
                break;
            case "Sym. axiale":
                shapes = shapes.stream().filter(shape -> shape instanceof IAxialSymmetry).toList();
                Axis axis = new Random().nextBoolean() ? Axis.X : Axis.Y;

                System.out.println("[ControlPanel] Axial symmetry on " + axis + " axis on " + shapes.size() + " shapes");
                shapes.forEach(shape -> ((IAxialSymmetry) shape).applyAxialSymmetry(axis));
                break;
            case "Sym. centrale":
                shapes = shapes.stream().filter(shape -> shape instanceof ICentralSymmetry).toList();
                Point center = new Point(new Random().nextInt(-10, 10), new Random().nextInt(-10, 10));

                System.out.println("[ControlPanel] Central symmetry on " + shapes.size() + " shapes around " + center);
                shapes.forEach(shape -> ((ICentralSymmetry) shape).applyCentralSymmetry(center));
                break;
            case "Homothétie":
                shapes = shapes.stream().filter(shape -> shape instanceof IHomothethy).toList();
                float scale = new Random().nextFloat(-1, 1);

                System.out.println("[ControlPanel] Homothety of " + scale + " on " + shapes.size() + " shapes");
                shapes.forEach(shape -> ((IHomothethy) shape).applyHomothety(scale));
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + button.getText());
        }

        System.out.println("[ControlPanel] Rechecking shapes and updating table and image !");
        this.updateUI();
    }

    private void onShapeClick(JButton button) {

        System.out.println("[ControlPanel] ShapeClick on " + button.getText());

        Image selectedImage = ImageController.getInstance().getCurrentImagePanel().getImage();
        System.out.println("[ControlPanel] " + selectedImage.getShapes().size() + " shapes in current image");

        Shape shape = switch (button.getText()) {
            case "Cercle" -> ShapeFactory.generateShape(Circle.class);
            case "Ligne" -> ShapeFactory.generateShape(Line.class);
            case "Ellipse" -> ShapeFactory.generateShape(Ellipsis.class);
            case "Polygone" -> ShapeFactory.generateShape(Polygon.class);
            default -> throw new IllegalStateException("Unexpected value: " + button.getText());
        };

        if (shape != null) {
            boolean isNewToImage = selectedImage.addShape(shape);
            System.out.println("[ControlPanel] " + (isNewToImage ? "Added" : "Not added") + " shape to selected image");
            if (!isNewToImage) {
                System.out.println("[ControlPanel] Shape with same values already exists in selected image, not adding it and trying to generate another one");
                JOptionPane.showMessageDialog(this, "Une forme avec les memes valeurs est déjà dans dans l'image. Tentative avec de nouvelles valeurs", "Erreur", JOptionPane.ERROR_MESSAGE);
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
            table.getScrollPane().setVisible(false);
        } else {

            System.out.println("[ControlPanel] Updating UI and table !");
            ImagePanel currentImagePanel = ImageController.getInstance().getCurrentImagePanel();
            Image currentImage = currentImagePanel.getImage();

            Fresco fresco = FrescoController.getInstance().getFrescoPanel().getFresco();
            System.out.println("[ControlPanel] Fresco informations => area : " + fresco.getArea() + " | perimeter : " + fresco.getPerimeter());
            System.out.println("[ControlPanel] Image informations => area : " + currentImage.getArea() + " | perimeter : " + currentImage.getPerimeter() + " | shapes : " + currentImage.getShapes().size());

            table.getModelShape().setShapes(currentImage.getShapes());
            selectAnImageLabel.setVisible(false);
            shapesPanel.setVisible(true);
            transformationsPanel.setVisible(true);
            table.getScrollPane().setVisible(true);
        }

    }

}

