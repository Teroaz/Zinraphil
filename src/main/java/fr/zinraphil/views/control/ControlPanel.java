package fr.zinraphil.views.control;

import fr.zinraphil.controllers.ControlController;
import fr.zinraphil.controllers.ImageController;
import fr.zinraphil.views.control.subcontrol.AbstractSubControlPanel;
import fr.zinraphil.views.control.subcontrol.CircleControlPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Arrays;
import java.util.Objects;

public class ControlPanel extends JPanel {

    private JButton currentShapeButton;
    private final JPanel shapesPanel;
    private final JLabel selectAnImageLabel;

    private AbstractSubControlPanel subControlPanel;

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

    public void reset() {
        if (subControlPanel != null) {
            this.remove(subControlPanel);
        }
        currentShapeButton = null;
        subControlPanel = null;

        this.updateUI();
    }

    private void onClick(ActionEvent itemEvent, JButton button) {

        if (currentShapeButton != null && Objects.equals(button.getText(), currentShapeButton.getText())) {
            return;
        }

        currentShapeButton = button;

        if (subControlPanel != null) this.remove(subControlPanel);

        System.out.println("Click on " + button.getText());
        switch (currentShapeButton.getText()) {
            case "Cercle" -> subControlPanel = new CircleControlPanel();
//            case "Ellipse" -> subControlPanel = new EllipsisControlPanel();
//            case "Ligne" -> subControlPanel = new LineControlPanel();
//            case "Polygone" -> subControlPanel = new PolygonControlPanel();
        }


        ControlController.getInstance().setSubControlPanel(subControlPanel);
        this.add(subControlPanel);

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

    public JButton getCurrentShapeButton() {
        return currentShapeButton;
    }

    public JLabel getSelectAnImageLabel() {
        return selectAnImageLabel;
    }

    public AbstractSubControlPanel getSubControlPanel() {
        return subControlPanel;
    }
}

