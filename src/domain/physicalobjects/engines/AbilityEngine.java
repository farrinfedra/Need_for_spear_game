package domain.physicalobjects.engines;
import java.util.*;

import domain.abilities.*;
import domain.physicalobjects.PhysicalObject;
public class AbilityEngine {
    private static AbilityEngine instance = null;

	private static int tickCounter = 0;
    private static Random rnd = new Random();

    private AbilityEngine() {}
    
    public static AbilityEngine getInstance() {
        if (instance == null)
            instance = new AbilityEngine();

        return instance;
    }
    
    public static void calculate(ArrayList<PhysicalObject> physicalObjects) {
    	tickCounter += 1;
    	if ( tickCounter == 30) {
    		//Reset Tick Counter
    		tickCounter = 0;
    		//coin toss
    		if (rnd.nextInt(2) == 1) {
    		int chosen = 0;//rnd.nextInt(3);
    		switch (chosen) {
    		case 0:
    			//sadece obstacles verilebilir
    			new InfiniteVoidAbility().perform(physicalObjects);
    		case 1:
    			//sadece paddleı verebiliriz
    			new DoubleAccelAbility().perform(physicalObjects);
    		case 2:
    			//Sadece obstacleları da verebiliriz
    			new HollowPurpleAbility().perform(physicalObjects);
    	}
			}
    	}
    	
    }
}
