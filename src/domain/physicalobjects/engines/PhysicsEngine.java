package domain.physicalobjects.engines;

import domain.physicalobjects.PhysicalObject;

import java.util.List;

public class PhysicsEngine {
    private static PhysicsEngine instance = null;

    private PhysicsEngine() {}

    public static PhysicsEngine getInstance() {
        if (instance == null)
            instance = new PhysicsEngine();

        return instance;
    }

    public void moveObjects(List<PhysicalObject> physicalObjects){
        for(PhysicalObject physicalObject: physicalObjects){
            physicalObject.getMovementBehavior().move(physicalObject);
        }
    }

}
