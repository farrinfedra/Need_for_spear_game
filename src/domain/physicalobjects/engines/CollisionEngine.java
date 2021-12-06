package domain.physicalobjects.engines;

import domain.physicalobjects.PhysicalObject;

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
        for(int i=0; i<physicalObjects.size()-1; i++){
            for(int j=i+1; j < physicalObjects.size(); j++){
                if(physicalObjects.get(i).getBoundingBox().isCollidingWith(
                        physicalObjects.get(j).getBoundingBox())){
                   physicalObjects.get(i).getCollisionBehavior().collide(physicalObjects.get(i), physicalObjects.get(j));
                   physicalObjects.get(j).getCollisionBehavior().collide(physicalObjects.get(j), physicalObjects.get(i));
                }
            }
        }
    }
}
