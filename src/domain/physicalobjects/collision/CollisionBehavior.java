package domain.physicalobjects.collision;

public interface CollisionBehavior {
     /*
        Collision Algorithm for o1 when o2 hits it.
     */
    public Boolean collide(Object o1, Object o2);
}
