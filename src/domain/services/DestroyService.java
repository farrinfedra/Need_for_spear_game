package domain.services;

import domain.GameBoard;
import domain.physicalobjects.PhysicalObject;

public class DestroyService extends GameBoardService {
    public DestroyService(GameBoard gameBoard) {
        super(ServiceType.DESTROY, gameBoard);
    }

    @Override
    public Object performSpecification(Object o) {
        PhysicalObject physicalObject = (PhysicalObject) o;
        getGameBoard().getPhysicalObjects().remove(physicalObject);

        return null;
    }
}
