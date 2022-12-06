package fr.zinraphil.controllers;

import fr.zinraphil.views.control.ControlPanel;
import fr.zinraphil.views.control.subcontrol.AbstractSubControlPanel;

public class ControlController {
    private static ControlController instance = null;

    private final ControlPanel controlPanel;

    private AbstractSubControlPanel subControlPanel;

    public ControlController(ControlPanel controlPanel) {
        instance = this;

        this.controlPanel = controlPanel;

    }

    public static ControlController getInstance() {
        if (instance == null) {
            throw new RuntimeException("ControlController not initialized");
        }
        return instance;
    }

    public ControlPanel getControlPanel() {
        return controlPanel;
    }

    public AbstractSubControlPanel getSubControlPanel() {
        return subControlPanel;
    }

    public void setSubControlPanel(AbstractSubControlPanel subControlPanel) {
        this.subControlPanel = subControlPanel;
    }
}

