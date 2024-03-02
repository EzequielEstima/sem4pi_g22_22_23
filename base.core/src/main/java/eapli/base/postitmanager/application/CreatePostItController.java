package eapli.base.postitmanager.application;

import eapli.base.exceptions.*;

public class CreatePostItController {

    private final CreatePostItService service = new CreatePostItService();
    public boolean createPostIt(String boardTittle, String content, int column, int row) throws CellOccupiedException,
            ZeroParameterException, NegativeParameterException, ParameterNullBlankException,
            InvalidContentSizeForAPostItException {
        return service.createPostIt(boardTittle, content, column, row);
    }
}
