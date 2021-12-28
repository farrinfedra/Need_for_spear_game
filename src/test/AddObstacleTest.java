package test;

import domain.Game;
import domain.GameBoard;
import domain.physicalobjects.PhysicalObject;
import domain.physicalobjects.behaviors.collision.ExplosiveObstacleCollisionBehavior;
import domain.physicalobjects.behaviors.collision.ObstacleCollisionBehavior;
import domain.physicalobjects.obstacles.ObstacleType;
import domain.physicalobjects.Vector;
import domain.physicalobjects.obstacles.Obstacle;
import domain.services.DestroyService;
import domain.services.SummonService;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static domain.physicalobjects.obstacles.ObstacleType.*;
import static org.junit.Assert.assertTrue;

public class AddObstacleTest {
    private GameBoard gameBoard;

    @Before
    public void setup(){
        Game.getInstance().createGameBoard(1000, 1000);
        gameBoard = Game.getInstance().getGameBoard();
    }

    @Test
    public void checkObstacleType(){
        for(ObstacleType type :ObstacleType.values()){
            gameBoard.addObstacle(type, new Vector(0,0));

            assertTrue(gameBoard.getPhysicalObjects().stream().anyMatch(physicalObject ->
                    {
                        if(physicalObject instanceof Obstacle)
                            return ((Obstacle) physicalObject).getClass()
                                    .getSimpleName()
                                    .equals(type.toString());
                        else
                            return false;
                    }
            ));
        }
    }

    @Test
    public void checkPhysicalObjectList(){
        ArrayList<Obstacle> obstacleList = new ArrayList<>();

        obstacleList.add(gameBoard.addObstacle(SimpleObstacle, new Vector(2,24)));
        obstacleList.add(gameBoard.addObstacle(FirmObstacle, new Vector(30,12)));
        obstacleList.add(gameBoard.addObstacle(GiftObstacle, new Vector(45,60)));
        obstacleList.add(gameBoard.addObstacle(ExplosiveObstacle, new Vector(105,16)));
        obstacleList.add(gameBoard.addObstacle(SimpleObstacle, new Vector(27,43)));
        obstacleList.add(gameBoard.addObstacle(FirmObstacle, new Vector(19,44)));

        List<PhysicalObject> physicalObjectList = gameBoard.getPhysicalObjects();
        for(Obstacle obstacle: obstacleList){
            assertTrue(physicalObjectList.contains(obstacle));
        }
    }

    @Test
    public void checkLocationVector(){
        Vector locationVector = new Vector(1905,1903);

        gameBoard.addObstacle(ObstacleType.SimpleObstacle, locationVector);
        assertTrue(gameBoard.getPhysicalObjects().stream().anyMatch(physicalObject ->
                {
                    if(physicalObject instanceof Obstacle)
                        return ((Obstacle) physicalObject).getLocation().equals(locationVector);
                    else
                        return false;
                }
        ));
    }

    @Test
    public void checkServicesOnObstacles(){
        Vector location = new Vector(100, 200);
        Obstacle simpleObstacle = gameBoard.addObstacle(SimpleObstacle, location);
        assertTrue(simpleObstacle.getService(0) instanceof DestroyService);

        Obstacle firmObstacle = gameBoard.addObstacle(FirmObstacle, location);
        assertTrue(firmObstacle.getService(0) instanceof DestroyService);

        Obstacle explosiveObstacle = gameBoard.addObstacle(ExplosiveObstacle, location);
        assertTrue(explosiveObstacle.getService(0) instanceof DestroyService);
        assertTrue(explosiveObstacle.getService(1) instanceof SummonService);

        Obstacle giftObstacle = gameBoard.addObstacle(GiftObstacle, location);
        assertTrue(giftObstacle.getService(0) instanceof DestroyService);
    }

    @Test
    public void checkHealth(){
        Vector location = new Vector(100, 200);
        Obstacle simpleObstacle = gameBoard.addObstacle(SimpleObstacle, location);
        assertTrue(simpleObstacle.getHealth() == 1);

        Obstacle firmObstacle = gameBoard.addObstacle(FirmObstacle, location);
        assertTrue(firmObstacle.getHealth() == 3);

        Obstacle explosiveObstacle = gameBoard.addObstacle(ExplosiveObstacle, location);
        assertTrue(explosiveObstacle.getHealth() == 1);

        Obstacle giftObstacle = gameBoard.addObstacle(GiftObstacle, location);
        assertTrue(giftObstacle.getHealth() == 1);
    }

    @Test
    public void checkCollisionBehaviour(){
        Vector location = new Vector(100, 200);
        Obstacle simpleObstacle = gameBoard.addObstacle(SimpleObstacle, location);
        assertTrue(simpleObstacle.getCollisionBehavior() instanceof ObstacleCollisionBehavior);

        Obstacle firmObstacle = gameBoard.addObstacle(FirmObstacle, location);
        assertTrue(firmObstacle.getCollisionBehavior() instanceof ObstacleCollisionBehavior);

        Obstacle explosiveObstacle = gameBoard.addObstacle(ExplosiveObstacle, location);
        assertTrue(explosiveObstacle.getCollisionBehavior() instanceof ExplosiveObstacleCollisionBehavior);

        Obstacle giftObstacle = gameBoard.addObstacle(GiftObstacle, location);
        assertTrue(giftObstacle.getCollisionBehavior() instanceof ObstacleCollisionBehavior);
    }


}
