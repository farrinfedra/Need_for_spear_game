package domain.physicalobjects.engines;

import domain.physicalobjects.PhysicalObject;
import domain.physicalobjects.behaviors.collision.Collision;

import java.util.List;

public class CollisionEngine {
    private static CollisionEngine instance = null;

    private CollisionEngine() {}

    public static CollisionEngine getInstance() {
        if (instance == null)
            instance = new CollisionEngine();

        return instance;
    }

    public void handleCollisions(List<PhysicalObject> physicalObjects){
        int size = physicalObjects.size();
        for(int i=0; i<size-1; i++){
            for(int j=i+1; j < size; j++){

                Collision collision =
                            physicalObjects.get(i).getBoundingBox().
                                    getCollisionWith(physicalObjects.get(j).getBoundingBox());

                if(collision != null){
                   physicalObjects.get(i).getCollisionBehavior().collide(physicalObjects.get(i), physicalObjects.get(j), collision);
                   physicalObjects.get(j).getCollisionBehavior().collide(physicalObjects.get(j), physicalObjects.get(i), collision.reverseNormal());
                }
            }
        }
    }
}
