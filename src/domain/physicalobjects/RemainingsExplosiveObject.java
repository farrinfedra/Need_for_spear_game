package domain.physicalobjects;

import javax.swing.ImageIcon;

import domain.physicalobjects.collision.RemainingsExplosiveObjectCollisionBehavior;
import domain.physicalobjects.movement.RemainingsExplosiveObjectMovementBehavior;

public class RemainingsExplosiveObject extends PhysicalObject{
	Boolean active;
    public RemainingsExplosiveObject(Vector location, ImageIcon image){
    	
        super(location, image, image.getIconWidth(), image.getIconHeight(), new RemainingsExplosiveObjectMovementBehavior(-10), new RemainingsExplosiveObjectCollisionBehavior());
    }
}
