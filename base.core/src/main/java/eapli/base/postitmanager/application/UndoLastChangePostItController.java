package eapli.base.postitmanager.application;

import eapli.base.exceptions.CellDoesNotExistException;
import eapli.base.exceptions.CellIsEmptyException;
import eapli.base.exceptions.CellOccupiedException;
import eapli.base.exceptions.UserDidNotCreatePostItException;

public class UndoLastChangePostItController {

    private final UndoLastChangePostItService service = new UndoLastChangePostItService();
    public void undoLastChangePostIt(String boardTittle, int column, int row)
            throws CellDoesNotExistException, CellIsEmptyException, UserDidNotCreatePostItException, CellOccupiedException {
        service.undoLastChangePostIt(boardTittle, column, row);
    }
}
