package test;
import domain.Game;
import domain.GameBoard;
import domain.physicalobjects.Vector;
import domain.physicalobjects.obstacles.FirmObstacle;
import domain.physicalobjects.obstacles.Obstacle;
import domain.physicalobjects.obstacles.ObstacleFactory;
import domain.physicalobjects.obstacles.ObstacleType;
import domain.services.GameBoardServiceFactory;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AddObstacleTest {

    @Test
    public void testObstacleType(){
        Game.getInstance().createGameBoard(1000, 1000);


        for(ObstacleType type :ObstacleType.values()){
            Game.getInstance().addObstacle(type, new Vector(0,0));
            GameBoard gameBoard = Game.getInstance().getGameBoard();

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
    public void testPhysicalObjectsList(){

    }

    @Test
    public void testLocationVector(){
        Vector locationVector = new Vector(1905,1903);

        Game.getInstance().createGameBoard(1000, 1000);
        Game.getInstance().addObstacle(ObstacleType.SimpleObstacle, locationVector);
        GameBoard gameBoard = Game.getInstance().getGameBoard();

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
    public void testIntersectingObstacles(){

    }
}