package domain.services;

import domain.GameBoard;
import domain.physicalobjects.PhysicalObject;

public class DestroyService extends GameBoardService {
    public DestroyService(GameBoard gameBoard) {
        super(gameBoard);
    }

    @Override
    public void perform(Object o) {
        //TO-DO
        //PhysicalObject physicalObject = (PhysicalObject) o;
        //getGameBoard().getPhysicalObjects().remove(physicalObject);
    }
}
