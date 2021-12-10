package domain.services;

import domain.GameBoard;
import domain.physicalobjects.PhysicalObject;

public class SummonService extends GameBoardService {
    public SummonService(GameBoard gameBoard) {
        super(gameBoard);
    }

    @Override
    public void perform(Object o) {
        PhysicalObject physicalObject = (PhysicalObject) o;
        getGameBoard().addPhysicalObject(physicalObject);
    }
}
