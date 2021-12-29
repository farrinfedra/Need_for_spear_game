package domain.physicalobjects.engines;
import java.util.*;

import domain.Constants;
import domain.abilities.*;
import domain.physicalobjects.Ball;
import domain.physicalobjects.Paddle;
import domain.physicalobjects.PhysicalObject;
public class AbilityEngine {
    private static AbilityEngine instance = null;
	private HashMap<Ability, Integer> timeLeftForAbility;

	private boolean test = true;

    private AbilityEngine() {
		timeLeftForAbility = new HashMap<>();
	}
    
    public static AbilityEngine getInstance() {
        if (instance == null)
            instance = new AbilityEngine();

        return instance;
    }
    
    public void calculate(ArrayList<PhysicalObject> physicalObjects) {

		//TEST CODE STARTS HERE
		/*
			Use this block to test your magical abilities.
			This will be executed once.
		 */
		if(test){
			test= false;
			Ability testAbility = new MagicalHexAbility(physicalObjects.stream().filter(physicalObject -> physicalObject instanceof Paddle).findFirst().get());
			activateAbility(testAbility);
		}
		//TEST CODE ENDS HERE

		//Updates time left for each ability, and
		//reverts the ones that has one time left.
		revertTimedOutAbilities();
    }

	private void activateAbility(Ability ability){
		ability.perform();
		timeLeftForAbility.put(ability, Constants.ABILITY_TIME);
	}

	private void revertTimedOutAbilities(){
		for(Ability ability: timeLeftForAbility.keySet()){
			Integer updatedTime = timeLeftForAbility.get(ability)-1;
			if(updatedTime == 0){
				timeLeftForAbility.remove(ability);
				ability.revert();
			}
			else
				timeLeftForAbility.put(ability, updatedTime);
		}
	}
}
