package domain.physicalobjects;

import domain.physicalobjects.behaviors.collision.CollisionBehavior;
import domain.physicalobjects.behaviors.collision.ExplosiveFragmentCollisionBehavior;
import domain.physicalobjects.behaviors.movement.ExplosiveFragmentMovementBehavior;
import domain.physicalobjects.behaviors.movement.MovementBehavior;
import domain.physicalobjects.boundingbox.BoundingBox;
import domain.services.GameBoardService;

import javax.swing.*;
import java.util.List;

public class ExplosiveFragment extends PhysicalObject{
    public ExplosiveFragment(Vector location) {
        super(location, null, 30, 30, new ExplosiveFragmentMovementBehavior(), new ExplosiveFragmentCollisionBehavior(), null);
    }
}
