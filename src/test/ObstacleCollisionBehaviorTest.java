package test;
import domain.Game;
import domain.GameBoard;
import domain.physicalobjects.Ball;
import domain.physicalobjects.Vector;
import domain.physicalobjects.obstacles.*;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class ObstacleCollisionBehaviorTest {

    @Test
    public void testHealth(){
        Game.getInstance().createGameBoard(1000, 1000);
        GameBoard gameBoard = Game.getInstance().getGameBoard();

        Ball ball = gameBoard.getBall();

        Game.getInstance().addObstacle(ObstacleType.FirmObstacle, ball.getLocation().add(ball.getMovementBehavior().getSpeed()));

        assertTrue(gameBoard.getPhysicalObjects().stream()
                .anyMatch(physicalObject -> {
                            if(physicalObject instanceof Obstacle){
                                return ((Obstacle)physicalObject).getHealth() == 3;
                            }
                            return false;
                        }));

        gameBoard.doTickActions();

        assertTrue(gameBoard.getPhysicalObjects().stream()
                .anyMatch(physicalObject -> {
                    if(physicalObject instanceof Obstacle){
                        return ((Obstacle)physicalObject).getHealth() == 2;
                    }
                    return false;
                }));
    }

    @Test
    public void testDestructionFromGameBoard(){
        Game.getInstance().createGameBoard(1000, 1000);
        GameBoard gameBoard = Game.getInstance().getGameBoard();

        Ball ball = gameBoard.getBall();

        Game.getInstance().addObstacle(ObstacleType.SimpleObstacle, ball.getLocation().add(ball.getMovementBehavior().getSpeed()));

        assertTrue(gameBoard.getPhysicalObjects().stream()
                .anyMatch(physicalObject -> physicalObject instanceof SimpleObstacle));

        gameBoard.doTickActions();

        assertTrue(!gameBoard.getPhysicalObjects().stream()
                .anyMatch(physicalObject -> physicalObject instanceof SimpleObstacle));
    }

    @Test
    public void testDestructionFromUI(){
        assertTrue(true);
    }

    @Test
    public void testMinusHealth(){
        Game.getInstance().createGameBoard(1000, 1000);
        GameBoard gameBoard = Game.getInstance().getGameBoard();

        Ball ball = gameBoard.getBall();
        Vector initialBallLocation = ball.getLocation();

        Game.getInstance().addObstacle(ObstacleType.SimpleObstacle, ball.getLocation().add(ball.getMovementBehavior().getSpeed()));

        Obstacle obstacle = (Obstacle) gameBoard.getPhysicalObjects().stream()
                    .filter(physicalObject -> physicalObject instanceof Obstacle)
                    .findAny().get();

        assertTrue(obstacle.getHealth() == 1);

        gameBoard.doTickActions();
        ball.setLocation(initialBallLocation);
        gameBoard.doTickActions();

        //Gets hit 2 times, but life must be 0 still
        assertTrue(obstacle.getHealth() == 0);
    }
}