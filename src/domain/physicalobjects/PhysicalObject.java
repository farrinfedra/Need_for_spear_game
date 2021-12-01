package domain.physicalobjects;

import domain.physicalobjects.boundingbox.BoundingBox;
import domain.physicalobjects.boundingbox.PolygonBoundingBox;

import javax.swing.*;

public class PhysicalObject {
    private Vector location;
    private ImageIcon image;

    private BoundingBox boundingBox;
    private int width;
    private int height;

    public PhysicalObject(Vector location, ImageIcon image) {
        this(location, image, image.getIconWidth(), image.getIconHeight());
    }

    public PhysicalObject(Vector location, ImageIcon image, int width, int height){
        this.location = location;
        this.image = image;
        this.width = width;
        this.height = height;

        this.boundingBox = new PolygonBoundingBox(
                location.add(new Vector(0, -height)), location.add(new Vector(width, -height)), location.add(new Vector(width, 0)), location
        );
    }

    public Vector getLocation() {
        return location;
    }

    public void setLocation(Vector location) {
        this.location = location;
    }

    public ImageIcon getImage() {
        return image;
    }

    public void setImage(ImageIcon image) {
        this.image = image;
    }

    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }

    public BoundingBox getBoundingBox(){
        return boundingBox;
    }

    public void setBoundingBox(BoundingBox boundingBox){
        this.boundingBox = boundingBox;
    }
}
