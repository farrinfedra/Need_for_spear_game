package domain.physicalobjects.obstacles;

import domain.physicalobjects.Vector;
import domain.physicalobjects.behaviors.collision.ObstacleCollisionBehavior;
import domain.physicalobjects.behaviors.movement.StationaryMovementBehavior;
import domain.services.Service;

import javax.swing.*;
import java.util.List;

public class FirmObstacle extends Obstacle{
    public FirmObstacle(Vector location, List<Service> services) {
        super(location, null,
                40, 40,
                new StationaryMovementBehavior(),
                new ObstacleCollisionBehavior(), 3, services);

        setImage(new ImageIcon(super.getClass().getResource("/ui/assets/FirmObstacleImageHealth3.png")));
    }

    @Override
    public void specialAttribute() {
        switch(this.getHealth()){
            case 2:
                this.setImage(new ImageIcon(super.getClass().getResource("/ui/assets/FirmObstacleImageHealth2.png")));
                break;
            case 1:
                this.setImage(new ImageIcon(super.getClass().getResource("/ui/assets/FirmObstacleImageHealth1.png")));
                break;
        }
    }

    @Override
    public String toString(){
        return "FirmObstacle";
    }

}
