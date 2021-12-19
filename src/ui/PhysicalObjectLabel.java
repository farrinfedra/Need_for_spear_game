package ui;

import domain.physicalobjects.PhysicalObject;
import domain.physicalobjects.Vector;
import domain.physicalobjects.boundingbox.PolygonBoundingBox;
import org.w3c.dom.css.RGBColor;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.util.Objects;

public class PhysicalObjectLabel extends JLabel{
    private PhysicalObject physicalObject;
    private Color color;

    public PhysicalObjectLabel(PhysicalObject physicalObject){
        super(physicalObject.getImage());
        this.physicalObject = physicalObject;

        this.color = new Color(0, 156,0);

        Vector location = physicalObject.getLocation();
        this.setBounds((int) location.getX(),(int) location.getY(), (int)physicalObject.getWidth(), (int)physicalObject.getHeight());
        this.setOpaque(true);
    }

    public void update(){
        Vector location = physicalObject.getLocation();
        this.setBounds((int) location.getX(),(int) location.getY(), (int)physicalObject.getWidth(), (int)physicalObject.getHeight());
    }

    //Probably gonna change name
    public void flash(){
        color = this.color.brighter();
        this.repaint();
    }

    public void unflash(){
        color = new Color(0, 156,0);
        this.repaint();
    }

    public PhysicalObject getPhysicalObject() {
        return physicalObject;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhysicalObjectLabel that = (PhysicalObjectLabel) o;
        return Objects.equals(physicalObject, that.physicalObject);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if(physicalObject.getImage() != null)
            g.drawImage(physicalObject.getImage().getImage(), 0, 0, new ImageObserver() {
                @Override
                public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
                    return false;
                }
            });
        else{
            g.setColor(this.color);
            if(physicalObject.getBoundingBox() instanceof PolygonBoundingBox)
                g.fill3DRect(0,0,(int) physicalObject.getWidth(),(int) physicalObject.getHeight(), true);
            else
                g.fillOval(0,0,(int) physicalObject.getWidth(),(int) physicalObject.getHeight());
        }



    }

    @Override
    public int hashCode() {
        return Objects.hash(physicalObject);
    }
}
