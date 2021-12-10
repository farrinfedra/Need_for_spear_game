package domain.physicalobjects;

import javax.swing.ImageIcon;

import domain.physicalobjects.behaviors.collision.ExplosiveFragmentCollisionBehavior;
import domain.physicalobjects.behaviors.movement.ExplosiveFragmentMovementBehavior;

public class RemainingsExplosiveObject extends PhysicalObject{
	Boolean active;
    public RemainingsExplosiveObject(Vector location, ImageIcon image){
    	
        super(location, image, image.getIconWidth(), image.getIconHeight(), new ExplosiveFragmentMovementBehavior(), new ExplosiveFragmentCollisionBehavior());
    }
}
