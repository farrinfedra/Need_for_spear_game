package domain.physicalobjects.engines;
import java.util.*;

import domain.abilities.*;
import domain.physicalobjects.PhysicalObject;
public class AbilityEngine {
    private static AbilityEngine instance = null;
    static int tickCounter = 0;
    static Random rnd = new Random();
    private AbilityEngine() {}
    
    public static AbilityEngine getInstance() {
        if (instance == null)
            instance = new AbilityEngine();

        return instance;
    }
    
    public void calculate(ArrayList<PhysicalObject> physicalObjects) {
    	tickCounter += 1;
    	if ( tickCounter == 30) {
    		//Reset Tick Counter
    		tickCounter = 0;
    		//coin toss
    		if (rnd.nextInt(2) == 1) {
    		int choosen = rnd.nextInt(3);
    		switch (choosen) {
    		case 0:
    			//sadece obstacles verilebilir
    			InfiniteVoidAbility.perform(physicalObjects);
    		case 1:
    			//sadece paddleı verebiliriz
    			DoubleAccelAbility.perform(physicalObjects);
    		case 2:
    			//Sadece obstacleları da verebiliriz
    			HollowPurpleAbility.perform(physicalObjects);
    	}
    		}
    	}
    	
    }
}
