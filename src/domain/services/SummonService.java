package domain.services;

import domain.GameBoard;
import domain.physicalobjects.PhysicalObject;

public class SummonService extends GameBoardService {
    public SummonService(GameBoard gameBoard) {
        super(gameBoard);
    }

    @Override
    public void performSpecification(Object o) {
        PhysicalObject physicalObject = (PhysicalObject) o;
        getGameBoard().addPhysicalObject(physicalObject);
    }
}
