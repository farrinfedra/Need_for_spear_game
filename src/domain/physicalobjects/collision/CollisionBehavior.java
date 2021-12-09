package domain.physicalobjects.collision;

public interface CollisionBehavior {
     /*
        Collision Algorithm for o1 when o2 hits it.
     */
    public void collide(Object o1, Object o2, Collision collision);
}
