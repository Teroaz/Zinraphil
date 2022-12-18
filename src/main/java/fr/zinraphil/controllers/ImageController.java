package fr.zinraphil.controllers;

import fr.zinraphil.views.fresco.ImagePanel;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * The ImageController class is a MouseListener and MouseMotionListener for ImagePanel objects.
 * It listens for mouse events on ImagePanel objects and updates the current ImagePanel and the ControlPanel.
 */
public class ImageController implements MouseListener, MouseMotionListener {

    private static ImageController instance = null;

    /**
     * The current ImagePanel that the mouse is interacting with.
     */
    private ImagePanel currentImagePanel;

    /**
     * Constructs a new ImageController and sets the instance variable to this object.
     */
    public ImageController() {
        System.out.println("> Instantiating ImageController");
        instance = this;
    }

    /**
     * Returns the single instance of ImageController. If the instance is not yet initialized,
     * this method throws a RuntimeException.
     *
     * @return The single instance of ImageController.
     */
    public static ImageController getInstance() {
        if (instance == null) {
            throw new RuntimeException("ImageController not initialized");
        }
        return instance;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    /**
     * {@inheritDoc}
     * <p>
     * If the left mouse button is pressed, this method updates the currentImagePanel to be the source
     * of the MouseEvent and updates the UI of the currentImagePanel and the ControlPanel.
     */
    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            System.out.println("[ImageController] Left mouse button pressed on " + e.getSource());
            currentImagePanel = (ImagePanel) e.getSource();
        }

        currentImagePanel.updateUI();
        ControlController.getInstance().getControlPanel().updateUI();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void mouseReleased(MouseEvent e) {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void mouseEntered(MouseEvent e) {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void mouseExited(MouseEvent e) {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void mouseDragged(MouseEvent e) {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void mouseMoved(MouseEvent e) {

    }

    /**
     * Returns the current ImagePanel that the mouse is interacting with.
     *
     * @return the current ImagePanel that the mouse is interacting with
     */
    public ImagePanel getCurrentImagePanel() {
        return currentImagePanel;
    }

}
