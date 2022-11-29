package fr.zinraphil.views.control;

import javax.swing.*;

public class LineControlPanel extends JPanel {

    public LineControlPanel() {
        super();

        JLabel label = new JLabel("Panneau de ligne");
        label.setFont(label.getFont().deriveFont(60f));
        this.add(label);
    }
}
