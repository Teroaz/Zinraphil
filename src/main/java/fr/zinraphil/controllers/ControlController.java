package fr.zinraphil.controllers;

import fr.zinraphil.views.control.ControlPanel;

/**
 * A class that controls a {@link ControlPanel}.
 * <p>
 * This class is a singleton, so only one instance can exist at any given time.
 * The instance can be obtained using the {@link #getInstance()} method.
 */
public class ControlController {
    /**
     * The single instance of this class.
     */
    private static ControlController instance = null;

    /**
     * The {@link ControlPanel} that this class controls.
     */
    private final ControlPanel controlPanel;

    /**
     * Constructs a new {@link ControlController} and sets the instance variable to this object.
     *
     * @param controlPanel the {@link ControlPanel} that this class should control
     */
    public ControlController(ControlPanel controlPanel) {
        instance = this;

        System.out.println("> Instantiating ControlController");
        this.controlPanel = controlPanel;
    }

    /**
     * Returns the single instance of this class.
     * <p>
     * If the instance has not been initialized (i.e. if {@link #ControlController(ControlPanel)} has not been called),
     * this method will throw a {@link RuntimeException}.
     *
     * @return the single instance of this class
     */
    public static ControlController getInstance() {
        if (instance == null) {
            throw new RuntimeException("ControlController not initialized");
        }
        return instance;
    }

    /**
     * Returns the {@link ControlPanel} that this class controls.
     *
     * @return the {@link ControlPanel} that this class controls
     */
    public ControlPanel getControlPanel() {
        return controlPanel;
    }
}


