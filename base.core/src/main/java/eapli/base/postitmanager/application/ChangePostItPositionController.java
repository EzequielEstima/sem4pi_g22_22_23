package eapli.base.postitmanager.application;

import eapli.base.exceptions.*;
import eapli.base.postitmanager.application.service.ChangePostItPositionService;

public class ChangePostItPositionController {
    public boolean changePostItPosition(String boardTitle, Integer oldRow, Integer oldColumn, Integer newRow, Integer newColumn) throws ZeroParameterException, ParameterNullBlankException, NegativeParameterException, InvalidContentSizeForAPostItException, CellDoesNotExistException, CellIsEmptyException, UserDidNotCreatePostItException {
        return new ChangePostItPositionService().changePostItPosition(boardTitle, oldRow, oldColumn, newRow, newColumn);
    }
}
