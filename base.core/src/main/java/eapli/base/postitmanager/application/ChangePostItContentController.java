package eapli.base.postitmanager.application;

import eapli.base.exceptions.*;
import eapli.base.postitmanager.application.service.ChangePostItContentService;

public class ChangePostItContentController {
    public boolean changePostItContent(String boardTitle, Integer row, Integer column, String content) throws ZeroParameterException, ParameterNullBlankException, NegativeParameterException, InvalidContentSizeForAPostItException, CellDoesNotExistException, CellIsEmptyException, UserDidNotCreatePostItException {
        return new ChangePostItContentService().changePostItContent(boardTitle, row, column, content);
    }
}
