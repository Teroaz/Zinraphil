package fr.zinraphil.controllers;

import fr.zinraphil.views.ZinraphilFrame;

/**
 * This class is a controller for the ZinraphilFrame class. It creates a single instance of the ZinraphilFrame
 * <p>
 * and provides methods for accessing it.
 *
 * @see ZinraphilFrame
 */
public class ZinraphilController {

    /**
     * The size of the images used in the ZinraphilFrame.
     */
    public static int IMAGE_SIZE = 250;
    /**
     * The single instance of the ZinraphilController.
     */
    private static ZinraphilController instance;
    /**
     * The ZinraphilFrame controlled by this ZinraphilController.
     */
    private final ZinraphilFrame zinraphilFrame;

    /**
     * Constructs a new ZinraphilController and creates a new ZinraphilFrame.
     */
    public ZinraphilController() {
        instance = this;

        System.out.println("> Instantiating ZinraphilController");
        zinraphilFrame = new ZinraphilFrame();
    }

    /**
     * Returns the ZinraphilFrame controlled by this ZinraphilController.
     *
     * @return the ZinraphilFrame controlled by this ZinraphilController
     */
    public ZinraphilFrame getZinraphilFrame() {
        return zinraphilFrame;
    }

    /**
     * Returns the single instance of the ZinraphilController.
     *
     * @return the single instance of the ZinraphilController
     */
    public static ZinraphilController getInstance() {
        return instance;
    }
}
