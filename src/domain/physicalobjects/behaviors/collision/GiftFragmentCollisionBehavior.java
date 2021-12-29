package domain.physicalobjects.behaviors.collision;

import domain.abilities.AbilityType;
import domain.physicalobjects.GiftFragment;
import domain.physicalobjects.Paddle;

public class GiftFragmentCollisionBehavior extends CollisionBehavior{
    @Override
    public void collide(Collision collision) {
        if(collision.getO2() instanceof Paddle){
            GiftFragment fragment = (GiftFragment) collision.getO1();
            fragment.getService(0).perform(fragment);
            fragment.getService(2).perform(AbilityType.HollowPurpleAbility);
        }
    }
}
