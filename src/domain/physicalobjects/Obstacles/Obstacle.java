package domain.physicalobjects.Obstacles;

import domain.physicalobjects.PhysicalObject;
import domain.physicalobjects.Vector;

import javax.swing.*;

public abstract class Obstacle extends PhysicalObject {
    int health;

    public Obstacle(Vector location, ImageIcon image, int width, int height) {
        super(location, image, width, height);
    }
}
