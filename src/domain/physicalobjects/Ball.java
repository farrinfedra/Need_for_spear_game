package domain.physicalobjects;
import domain.Constants;
import domain.physicalobjects.boundingbox.SphereBoundingBox;
import domain.physicalobjects.behaviors.collision.BallCollisionBehavior;
import domain.physicalobjects.behaviors.movement.BallMovementBehavior;

import javax.swing.*;

public class Ball extends PhysicalObject{

	private int attackDamage;

    public Ball(Vector location, double width, double height ){
        super(location, width, height,
				new SphereBoundingBox(location.add(new Vector(width/2, width/2)), width/2 )
				, new BallMovementBehavior(), new BallCollisionBehavior(), null);

		attackDamage = Constants.BALL_ATTACK_DAMAGE;
    }

	public Vector getSpeed() {
		return  ((BallMovementBehavior) getMovementBehavior()).getSpeed();
	}
	public void setSpeed(Vector speed) {
		 ((BallMovementBehavior) getMovementBehavior()).setSpeed(speed);
	}

	public void setAttackDamage(int attackDamage) {
		this.attackDamage = attackDamage;
	}

	public int getAttackDamage(){
		return this.attackDamage;
	}
}
