package ui;

import domain.physicalobjects.PhysicalObject;

import javax.swing.*;
import java.awt.*;

public class PhysicalObjectLabel extends JLabel{
    private PhysicalObject physicalObject;

    public PhysicalObjectLabel(PhysicalObject physicalObject){
        super(physicalObject.getImage());
        this.physicalObject = physicalObject;
        this.setBackground(Color.GREEN);
        this.setOpaque(true);
    }


    public PhysicalObject getPhysicalObject() {
        return physicalObject;
    }
}
