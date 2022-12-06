package fr.zinraphil.views.control;

import fr.zinraphil.controllers.ImageController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Arrays;
import java.util.Objects;

public class ControlPanel extends JPanel {

    private JButton currentShapeButton;
    private final JPanel shapesPanel;
    private final JLabel selectAnImageLabel;

    private JPanel subControlPanel = new JPanel();

    public ControlPanel() {
        super();

        BoxLayout boxLayout = new BoxLayout(this, BoxLayout.PAGE_AXIS);
        this.setLayout(boxLayout);

        JLabel label = new JLabel("Panneau de controle");
        label.setFont(label.getFont().deriveFont(60f));
        this.add(label);

        selectAnImageLabel = new JLabel("Selectionnez une image");
        selectAnImageLabel.setFont(selectAnImageLabel.getFont().deriveFont(30f));
        this.add(selectAnImageLabel);

        shapesPanel = new JPanel();
        shapesPanel.setLayout(new BoxLayout(shapesPanel, BoxLayout.X_AXIS));

        String[] shapes = {"Cercle", "Ellipse", "Ligne", "Polygone"};
        Arrays.stream(shapes).map(JButton::new).forEach(button -> {
            button.setSize(100, 100);
            button.addActionListener(e -> onClick(e, button));
            shapesPanel.add(button);
        });

        shapesPanel.setVisible(false);
        this.add(shapesPanel);
        this.add(subControlPanel);

    }

    private void onClick(ActionEvent itemEvent, JButton button) {

        if (currentShapeButton != null && Objects.equals(button.getText(), currentShapeButton.getText())) {
            return;
        }

        currentShapeButton = button;

        if (subControlPanel != null) this.remove(subControlPanel);

        switch (currentShapeButton.getText()) {
            case "Cercle" -> subControlPanel = new CircleControlPanel();
            case "Ellipse" -> subControlPanel = new EllipsisControlPanel();
            case "Ligne" -> subControlPanel = new LineControlPanel();
            case "Polygone" -> subControlPanel = new PolygonControlPanel();
        }

        this.add(subControlPanel);

        this.updateUI();
    }

    @Override
    public void updateUI() {
        super.updateUI();
        if (selectAnImageLabel == null) return;

        if (ImageController.currentImagePanel == null) {
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

    public JButton getCurrentShapeButton() {
        return currentShapeButton;
    }

    public JLabel getSelectAnImageLabel() {
        return selectAnImageLabel;
    }
}

