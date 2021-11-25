package domain.physicalObjects.Obstacles;

import domain.physicalObjects.Vector;

import javax.swing.*;

public class GiftObstacle extends Obstacle{

    public GiftObstacle(Vector location, ImageIcon image, int width, int height) {
        super(location, image, width, height);
        this.health = 1;
    }
}
