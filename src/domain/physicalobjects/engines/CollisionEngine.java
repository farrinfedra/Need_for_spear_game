package domain.physicalobjects.engines;

import domain.RemoveObjectListener;
import domain.physicalobjects.PhysicalObject;
import domain.physicalobjects.Vector;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

public class CollisionEngine {
    private static CollisionEngine instance = null;
    private List<RemoveObjectListener> removeObjectListeners = new ArrayList<>();

    private CollisionEngine() {}

    public static CollisionEngine getInstance() {
        if (instance == null)
            instance = new CollisionEngine();

        return instance;
    }

    public void publishRemoveObjectEvent(PhysicalObject physicalObject){
        for(RemoveObjectListener l: removeObjectListeners){
            l.onPropertyEvent(physicalObject);
        }

    }
    public void addRemoveObjectListener(RemoveObjectListener listener){
        removeObjectListeners.add(listener);
    }

    public void handleCollisions(List<PhysicalObject> physicalObjects){
        Boolean firstObjectIsBroken;
        Boolean secondObjectIsBroken;
        for(int i=0; i<physicalObjects.size()-1; i++){
            for(int j=i+1; j < physicalObjects.size(); j++){
                firstObjectIsBroken = false;
                secondObjectIsBroken = false;
                if(physicalObjects.get(i).getBoundingBox().isCollidingWith(
                        physicalObjects.get(j).getBoundingBox())){
                    firstObjectIsBroken = physicalObjects.get(i).getCollisionBehavior().collide(physicalObjects.get(i), physicalObjects.get(j));
                    secondObjectIsBroken = physicalObjects.get(j).getCollisionBehavior().collide(physicalObjects.get(j), physicalObjects.get(i));
                }

                if (firstObjectIsBroken){
                    publishRemoveObjectEvent(physicalObjects.get(i));
                } else if (secondObjectIsBroken){
                    publishRemoveObjectEvent(physicalObjects.get(j));
                }

            }
        }
    }
}
