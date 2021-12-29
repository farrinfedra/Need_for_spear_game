package ui;

import domain.physicalobjects.*;
import domain.physicalobjects.obstacles.ExplosiveObstacle;
import domain.physicalobjects.obstacles.FirmObstacle;
import domain.physicalobjects.obstacles.GiftObstacle;
import domain.physicalobjects.obstacles.SimpleObstacle;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.net.URL;
import java.util.Objects;

public class PhysicalObjectLabel{
    private int width;
    private int height;
    private PhysicalObject physicalObject;
    private ImageIcon imageIcon;

    public PhysicalObjectLabel(PhysicalObject physicalObject){
        this.physicalObject = physicalObject;

        String resource;
        if(physicalObject instanceof SimpleObstacle)
            resource = Constants.SIMPLE_OBSTACLE_IMG_PATH;
        else if(physicalObject instanceof FirmObstacle)
            resource = Constants.FIRM_OBSTACLE_IMG_PATH;
        else if(physicalObject instanceof GiftObstacle)
            resource = Constants.GIFT_OBSTACLE_IMG_PATH;
        else if(physicalObject instanceof ExplosiveObstacle)
            resource = Constants.EXPLOSIVE_OBSTACLE_IMG_PATH;
        else if(physicalObject instanceof Ball)
            resource = Constants.BALL_IMG_PATH;
        else if(physicalObject instanceof Paddle)
            resource = Constants.PADDLE_IMG_PATH;
        else if(physicalObject instanceof ExplosiveFragment)
            resource = Constants.EXPLOSIVE_FRAGMENT_IMG_PATH;
        else
            resource = Constants.BALL_IMG_PATH;

        imageIcon = new ImageIcon(this.getClass().getResource(resource));
    }

    public PhysicalObject getPhysicalObject() {
        return physicalObject;
    }

    public void paint(Graphics g) {
        Vector location = physicalObject.getLocation();
        int x = (int) location.getX();
        int y = (int) location.getY();

        g.drawImage(imageIcon.getImage()
                ,x, y, (int) physicalObject.getWidth(), (int) physicalObject.getHeight(), new ImageObserver() {
                    @Override
                    public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
                        return false;
                    }
        });
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhysicalObjectLabel that = (PhysicalObjectLabel) o;
        return Objects.equals(physicalObject, that.physicalObject);
    }

    @Override
    public int hashCode() {
        return Objects.hash(physicalObject);
    }
}
