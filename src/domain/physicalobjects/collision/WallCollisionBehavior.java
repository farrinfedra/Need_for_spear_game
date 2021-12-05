package domain.physicalobjects.collision;

public class WallCollisionBehavior implements CollisionBehavior{

    @Override
    public Boolean collide(Object o1, Object o2) {
        return false;
    }
}
