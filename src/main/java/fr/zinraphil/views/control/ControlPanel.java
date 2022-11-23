package fr.zinraphil.views.control;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ControlPanel extends JPanel {

    private JButton currentShapeButton;

    public ControlPanel() {
        super();

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel label = new JLabel("Zinraphil");
        label.setFont(label.getFont().deriveFont(60f));
        this.add(label);

        JPanel shapesPanel = new JPanel();
        shapesPanel.setLayout(new BoxLayout(shapesPanel, BoxLayout.Y_AXIS));
        shapesPanel.setAlignmentX(CENTER_ALIGNMENT);

        JButton circleButton = new JButton("Cercle");
        circleButton.addActionListener(e -> onClick(e, circleButton));
        shapesPanel.add(circleButton);

        JButton ellipseButton = new JButton("Ellipse");
        ellipseButton.addActionListener(e -> onClick(e, ellipseButton));
        shapesPanel.add(ellipseButton);

        JButton lineButton = new JButton("Ligne");
        lineButton.addActionListener(e -> onClick(e, lineButton));
        shapesPanel.add(lineButton);

        JButton polygonButton = new JButton("Polygone");
        polygonButton.addActionListener(e -> onClick(e, polygonButton));
        shapesPanel.add(polygonButton);

        this.add(shapesPanel);
    }

    private void onClick(ActionEvent itemEvent, JButton button) {
        currentShapeButton = button;
    }

    @Override
    public void update(Graphics g) {
        super.update(g);

    }
}

