package domain.abilities;

import java.util.ArrayList;
import java.util.List;

import domain.physicalobjects.PhysicalObject;
import domain.physicalobjects.obstacles.Obstacle;

public class InfiniteVoidAbility extends Ability {

	public InfiniteVoidAbility(PhysicalObject appliesTo) {
		super(appliesTo);
	}

	public void perform() {
		List<Obstacle> obstacles = (List<Obstacle>) getService(0).perform(null);
		System.out.println(obstacles.size());
	}

	@Override
	public void revert() {

	}

}
