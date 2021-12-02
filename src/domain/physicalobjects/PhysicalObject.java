package domain.physicalobjects;

import javax.swing.*;

public abstract class PhysicalObject {
    private Vector location;
    private ImageIcon image;

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
}
