package domain.physicalobjects;

import domain.Direction;

import javax.swing.*;

public class Paddle extends PhysicalObject{

    private int speed;
    private int minXValue;
    private int maxXValue;

    public Paddle(Vector location, ImageIcon image, int minXValue, int maxXValue){
        super(location, image);

        speed = 0;
        this.minXValue = minXValue;
        this.maxXValue = maxXValue;
    }

    public void move(){
        int dx = speed;

        Vector shiftVector = new Vector(dx, 0);
        Vector newLocation = getLocation().add(shiftVector);

        if(newLocation.getX()+getWidth()<maxXValue && newLocation.getX()>minXValue)
            setLocation(newLocation);

        speed = 95*speed/100;
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
