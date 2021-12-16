package domain.abilities;

import java.util.ArrayList;
import java.util.List;

import domain.physicalobjects.PhysicalObject;
import domain.physicalobjects.obstacles.Obstacle;

public class InfiniteVoidAbility extends Ability {

	public void perform(Object o) {
		List<Obstacle> obstacles = (List<Obstacle>) getService(0).perform(null);
		System.out.println(obstacles.size());
	}

}
