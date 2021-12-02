package domain.physicalobjects;

import domain.Direction;

import javax.swing.*;
import java.awt.image.BufferedImage;

public class Paddle extends PhysicalObject{

    private int speed;
    private int minXValue;
    private int maxXValue;

    public Paddle(Vector location, ImageIcon image, int minXValue, int maxXValue){
        super(location, image);

        speed = 20;
        this.minXValue = minXValue;
        this.maxXValue = maxXValue;
    }

    public void move(Direction direction){
        int dx = speed;
        dx = direction == Direction.LEFT ? -1*dx : dx;

        Vector shiftVector = new Vector(dx, 0);
        Vector newLocation = getLocation().shift(shiftVector);

        if(newLocation.getX()+getWidth()<maxXValue && newLocation.getX()>minXValue)
            setLocation(newLocation);
    }

    public void rotate(Direction direction){
        //TODO
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
