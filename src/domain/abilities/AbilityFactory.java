package domain.abilities;

import domain.physicalobjects.PhysicalObject;
import domain.physicalobjects.Vector;

import domain.services.GameBoardServiceFactory;
import domain.services.ServiceType;
import domain.services.Service;

import java.util.ArrayList;
import java.util.List;

public class AbilityFactory {
    private static AbilityFactory instance;

    private AbilityFactory() {
    }

    public static AbilityFactory getInstance() {
        if (instance == null) {
            instance = new AbilityFactory();
        }
        return instance;
    }

    public Ability create(UsefulAbilityType type, PhysicalObject appliesTo) {
        switch (type) {
            case ChanceGivingAbility:
                return new ChanceGivingAbility(appliesTo);
            case MagicalHexAbility:
                return new MagicalHexAbility(appliesTo);
            case PaddleExpansionAbility:
                return new PaddleExpansionAbility(appliesTo);
            case UnstoppableBallAbility:
                return new UnstoppableBallAbility(appliesTo);
        }
        return null;
    }
}
