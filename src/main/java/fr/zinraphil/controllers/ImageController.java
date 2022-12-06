package fr.zinraphil.controllers;

import fr.zinraphil.views.fresco.ImagePanel;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class ImageController implements MouseListener, MouseMotionListener {

    private static ImageController instance = null;

    private ImagePanel currentImagePanel;

    public ImageController() {
        instance = this;
    }

    public static ImageController getInstance() {
        if (instance == null) {
            throw new RuntimeException("ImageController not initialized");
        }
        return instance;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            currentImagePanel = (ImagePanel) e.getSource();
        }

        currentImagePanel.updateUI();
        ControlController.getInstance().getControlPanel().updateUI();
    }


    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    public ImagePanel getCurrentImagePanel() {
        return currentImagePanel;
    }

}
