package domain;

import domain.abilities.*;
import domain.physicalobjects.*;
import domain.physicalobjects.behaviors.collision.BallCollisionBehavior;
import domain.physicalobjects.engines.AbilityEngine;
import domain.physicalobjects.engines.CollisionEngine;
import domain.physicalobjects.engines.PhysicsEngine;
import domain.physicalobjects.obstacles.*;
import domain.services.DestroyService;
import domain.services.GameBoardServiceFactory;
import domain.services.Service;
import domain.services.SummonService;

import java.util.ArrayList;
import java.util.List;


public class GameBoard{
    private ArrayList<PhysicalObject> physicalObjects;

    private Ball ball;
    private Paddle paddle;
    private Vector size;
    private Player player;

    public GameBoard(Vector size){
        this.size = size;
        physicalObjects = new ArrayList<>();

        List<Service> basicServices = new ArrayList<>();
        basicServices.add(new SummonService(this));
        basicServices.add(new DestroyService(this));

        paddle = new Paddle(new Vector(size.getX()/2 - 100,size.getY()-100), 200, 20, basicServices);
        ball = new Ball(new Vector(size.getX()/2 - 12.5,size.getY()-126), 25, 25, paddle.getMovementBehavior(), new BallCollisionBehavior());
        ball.setSpeed(new Vector(0,0));
        player = new Player();
        physicalObjects.add(ball);
        physicalObjects.add(paddle);
        physicalObjects.add(new Wall(new Vector(0,-21), size.getX(), 20));
        physicalObjects.add(new Wall(new Vector(-21,20), 20, size.getY()));
        physicalObjects.add(new Wall(new Vector(size.getX()+1, 0), 20, size.getY()));
        physicalObjects.add(new Wall(new Vector(0, size.getY()+1), size.getX(), 20));
    }

    public void addPhysicalObject(PhysicalObject physicalObject){
        physicalObjects.add(physicalObject);
    }

    public List<PhysicalObject> getPhysicalObjects(){
        return this.physicalObjects;
    }

    public Obstacle addObstacle(ObstacleType type, Vector location){
        //MODIFIES: physicalObjects list
        //EFFECTS: adds a new obstacle to physicalObjects list on given location and in given type.

        Obstacle obstacle = ObstacleFactory.getInstance().create(type, location, GameBoardServiceFactory.getInstance().setGameBoard(this));
        physicalObjects.add(obstacle);
        return obstacle;
    }

    public void movePaddle(Direction direction){ paddle.setSpeed((direction == Direction.LEFT) ? new Vector(-9, 0): new Vector(9, 0)); }
    public void rotatePaddle(Direction direction){ paddle.rotate(direction); }

    public void doTickActions(){
        //TODO: implement doTickActions
        CollisionEngine.getInstance().handleCollisions(physicalObjects);
        PhysicsEngine.getInstance().moveObjects(physicalObjects);
        AbilityEngine.getInstance().calculate(physicalObjects);
    }

    public Vector getSize() {
        return size;
    }

    public Ball getBall(){
        return ball;
    }

    public void shootMagicalHex() {
        paddle.shootMagicalHex();
    }

    public List<AbilityType> getAvailableAbilities() {
       return player.getAbilities();
    }

    public Player getPlayer() {
        return player;
    }

    public void useAbility(AbilityType type) {
        if(player.removeAbility(type)){
            Ability ability = AbilityFactory.getInstance().create(type, physicalObjects);
            AbilityEngine.getInstance().activateAbility(ability);
        }
    }

    public void infiniteVoid() {
        Ability ability = AbilityFactory.getInstance().create(AbilityType.InfiniteVoidAbility, physicalObjects);
        AbilityEngine.getInstance().activateAbility(ability);
    }

    public void doubleAccel() {
        Ability ability = AbilityFactory.getInstance().create(AbilityType.DoubleAccelAbility, physicalObjects);
        AbilityEngine.getInstance().activateAbility(ability);
    }

    public void hollowPurple() {
        Ability ability = AbilityFactory.getInstance().create(AbilityType.HollowPurpleAbility, physicalObjects);
        AbilityEngine.getInstance().activateAbility(ability);
    }

    public void setStickToPaddle(Boolean value) {
        ball.setStickToPaddle(value);
    }

    public void shootBall() {
        if (isBallStickToPaddle()) {
            ball.shoot();
            setStickToPaddle(false);
        }
    }

    public Boolean isBallStickToPaddle() {
        return ball.getStickToPaddle();
    }

    public void loseChance() {
        int chance = player.getLives();
        player.setLives(--chance);
        if (chance <= 0) {
            System.out.println("YOU LOST");
        } else {
            paddle.getBoundingBox().shift(new Vector(size.getX()/2 - 100,size.getY()-100).subtract(paddle.getLocation()));
            paddle.setLocation(new Vector(size.getX()/2 - 100,size.getY()-100));
            ball.getBoundingBox().shift(new Vector(size.getX()/2 - 12.5,size.getY()-126).subtract(ball.getLocation()));
            ball.setLocation(new Vector(size.getX()/2 - 12.5,size.getY()-126));
            ball.setMovementBehavior(paddle.getMovementBehavior());
            ball.setStickToPaddle(true);
        }
    }

    public void increaseChance() {
        int chance = player.getLives();
        player.setLives(++chance);
    }
}
