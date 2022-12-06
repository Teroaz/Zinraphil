package fr.zinraphil.controllers;

import fr.zinraphil.views.control.ControlPanel;
import fr.zinraphil.views.control.subcontrol.AbstractSubControlPanel;
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
            if (currentImagePanel != e.getSource()) {
//                ControlController.getInstance().getControlPanel()
            }
            currentImagePanel = (ImagePanel) e.getSource();

            AbstractSubControlPanel subControlPanel = ControlController.getInstance().getSubControlPanel();
            System.out.println(subControlPanel);
            if (subControlPanel != null) {
                subControlPanel.onMouseClick(e.getX(), e.getY());
                ControlController.getInstance().getControlPanel().reset();
            }


            ImageController.getInstance().getCurrentImagePanel().updateUI();
            ControlController.getInstance().getControlPanel().updateUI();
        }
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
        ControlPanel controlPanel = ControlController.getInstance().getControlPanel();

        if (controlPanel == null || controlPanel.getSubControlPanel() == null) return;

        if (currentImagePanel == e.getSource()) {
            controlPanel.getSubControlPanel().onMouseMove(e.getX(), e.getY());
        }
    }

    public ImagePanel getCurrentImagePanel() {
        return currentImagePanel;
    }

}
