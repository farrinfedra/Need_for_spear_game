package domain.physicalobjects.engines;
import java.util.*;
public class AbilityEngine {
    private static AbilityEngine instance = null;

    private AbilityEngine() {}
    
    public static AbilityEngine getInstance() {
        if (instance == null)
            instance = new AbilityEngine();

        return instance;
    }
}
