package ui;

import domain.physicalobjects.PhysicalObject;
import domain.physicalobjects.Vector;

import javax.swing.*;
import java.awt.*;

public class PhysicalObjectLabel extends JLabel{
    private PhysicalObject physicalObject;

    public PhysicalObjectLabel(PhysicalObject physicalObject){
        super(physicalObject.getImage());
        this.physicalObject = physicalObject;
        this.setBackground(Color.GREEN);
        this.setOpaque(true);

        Vector location = physicalObject.getLocation();
        this.setBounds((int) location.getX(),(int) location.getY(), (int)physicalObject.getWidth(), (int)physicalObject.getHeight());
    }

    public void update(){
        Vector location = physicalObject.getLocation();
        this.setBounds((int) location.getX(),(int) location.getY(), (int)physicalObject.getWidth(), (int)physicalObject.getHeight());
    }

    public PhysicalObject getPhysicalObject() {
        return physicalObject;
    }
}
