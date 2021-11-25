package domain.physicalObjects.Obstacles;

import domain.physicalObjects.PhysicalObject;
import domain.physicalObjects.Vector;

import javax.swing.*;

public abstract class Obstacle extends PhysicalObject {
    int health;

    public Obstacle(Vector location, ImageIcon image, int width, int height) {
        super(location, image, width, height);
    }
}
