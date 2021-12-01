package domain.physicalobjects;

import domain.physicalobjects.boundingbox.PolygonBoundingBox;

import javax.swing.*;

public class Wall extends PhysicalObject{

    public Wall(Vector location, int width, int height) {
        super(location, null, width, height);
    }
}
