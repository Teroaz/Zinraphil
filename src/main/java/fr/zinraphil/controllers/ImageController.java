package fr.zinraphil.controllers;

import fr.zinraphil.views.fresco.ImagePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ImageController implements MouseListener {

    private static ImageController instance = null;

    static ImagePanel currentImagePanel;

    private ImageController() {
        instance = this;
    }

    public static ImageController getInstance() {
        if (instance == null) {
            new ImageController();
        }
        return instance;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            if (currentImagePanel != null) {
                currentImagePanel.setBorder(null);
            }
            currentImagePanel = (ImagePanel) e.getSource();
            if (currentImagePanel != null) {
                currentImagePanel.setBorder(BorderFactory.createLineBorder(Color.RED, 5));
            }
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
}
