package domain.services;

import domain.GameBoard;
import domain.abilities.Ability;
import domain.abilities.AbilityType;

public class EquipAbilityService extends GameBoardService{
    public EquipAbilityService(GameBoard gameBoard) {
        super(ServiceType.EQUIP_ABILITY, gameBoard);
    }

    @Override
    Object performSpecification(Object o) {
        getGameBoard().getPlayer().getAbilities().add((AbilityType) o);
        return null;
    }
}
