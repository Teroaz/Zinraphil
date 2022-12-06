package fr.zinraphil.views.control.subcontrol;

import fr.zinraphil.controllers.ControlController;
import fr.zinraphil.controllers.ImageController;
import fr.zinraphil.models.geometry.Shape;

import javax.swing.*;

public abstract class AbstractSubControlPanel<T extends Shape<T>> extends JPanel {

    protected T shape;

    public AbstractSubControlPanel(String title) {
        super();
        this.setBorder(BorderFactory.createTitledBorder(title));
    }

    public abstract void onMouseMove(int x, int y);

    public abstract void onMouseClick(int x, int y);

    public T getShape() {
        return shape;
    }

    protected void addShape(T shape) {
        ControlController.getInstance().getControlPanel().reset();

        ImageController.getInstance().getCurrentImagePanel().getImage().addShape(shape);
    }

}
