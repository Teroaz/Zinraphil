package fr.zinraphil.controllers;

import fr.zinraphil.views.fresco.FrescoPanel;

/**
 * A class that controls a {@link FrescoPanel}.
 * <p>
 * This class is a singleton, so only one instance can exist at any given time.
 * The instance can be obtained using the {@link #getInstance()} method.
 */
public class FrescoController {
    /**
     * The single instance of this class.
     */
    private static FrescoController instance = null;

    /**
     * The {@link FrescoPanel} that this class controls.
     */
    private final FrescoPanel frescoPanel;


    /**
     * Constructs a new {@link FrescoController} and sets the instance variable to this object.
     *
     * @param frescoPanel the {@link FrescoPanel} that this class should control
     */
    public FrescoController(FrescoPanel frescoPanel) {
        instance = this;

        System.out.println("> Instantiating FrescoController");
        this.frescoPanel = frescoPanel;
    }

    /**
     * Returns the single instance of this class.
     * <p>
     * If the instance has not been initialized (i.e. if {@link #FrescoController(FrescoPanel)} has not been called),
     * this method will throw a {@link RuntimeException}.
     *
     * @return the single instance of this class
     */
    public static FrescoController getInstance() {
        if (instance == null) {
            throw new RuntimeException("FrescoController not initialized");
        }
        return instance;
    }

    /**
     * Returns the {@link FrescoPanel} that this class controls.
     *
     * @return the {@link FrescoPanel} that this class controls
     */
    public FrescoPanel getFrescoPanel() {
        return frescoPanel;
    }

}
