package fr.zinraphil.views.control;

import javax.swing.*;

public class PolygonControlPanel extends JPanel {

    public PolygonControlPanel() {
        super();

        JLabel label = new JLabel("Panneau de polygone");
        label.setFont(label.getFont().deriveFont(60f));
        this.add(label);
    }
}
