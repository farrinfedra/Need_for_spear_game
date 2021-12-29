package domain.physicalobjects;

import domain.physicalobjects.behaviors.collision.ExplosiveFragmentCollisionBehavior;
import domain.physicalobjects.behaviors.collision.GiftFragmentCollisionBehavior;
import domain.physicalobjects.behaviors.movement.ExplosiveFragmentMovementBehavior;

import domain.physicalobjects.behaviors.movement.GiftFragmentMovementBehavior;
import domain.services.GameBoardService;
import domain.services.Service;

import javax.swing.*;
import java.util.List;

public class GiftFragment extends PhysicalObject{
    public GiftFragment(Vector location, List<Service> services) {
        super(location, null, 30, 30, new GiftFragmentMovementBehavior(), new GiftFragmentCollisionBehavior(), services);
    }
}
