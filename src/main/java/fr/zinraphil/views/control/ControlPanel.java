package fr.zinraphil.views.control;

import fr.zinraphil.controllers.ImageController;
import fr.zinraphil.models.geometry.Circle;
import fr.zinraphil.models.geometry.Line;
import fr.zinraphil.models.geometry.Point;
import fr.zinraphil.models.geometry.Shape;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Arrays;
import java.util.Random;

import static fr.zinraphil.controllers.ZinraphilController.IMAGE_SIZE;

public class ControlPanel extends JPanel {

    private final JPanel shapesPanel;
    private final JLabel selectAnImageLabel;

    public ControlPanel() {
        super();

        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

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
            button.addActionListener(e -> onClick(e, button));
            shapesPanel.add(button);
        });

        shapesPanel.setVisible(false);
        this.add(shapesPanel);
    }

    private void onClick(ActionEvent itemEvent, JButton button) {

        System.out.println("Click on " + button.getText());

        switch (button.getText()) {
            case "Cercle" -> {
                Random random = new Random();
                int radius = random.nextInt(5, 50);
                Shape shape = new Circle(new Point(random.nextInt(IMAGE_SIZE - radius), random.nextInt(IMAGE_SIZE - radius)), radius);

                ImageController.getInstance().getCurrentImagePanel().getImage().addShape(shape);
            }

            case "Ligne" -> {
                Random random = new Random();
                Shape shape = new Line(new Point(random.nextInt(IMAGE_SIZE), random.nextInt(IMAGE_SIZE)), new Point(random.nextInt(IMAGE_SIZE), random.nextInt(IMAGE_SIZE)));

                ImageController.getInstance().getCurrentImagePanel().getImage().addShape(shape);
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
        } else {
            selectAnImageLabel.setVisible(false);
            shapesPanel.setVisible(true);
        }

    }

    public JPanel getShapesPanel() {
        return shapesPanel;
    }

    public JLabel getSelectAnImageLabel() {
        return selectAnImageLabel;
    }
}

