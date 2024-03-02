package eapli.base.board.application;

import eapli.base.board.application.services.ShareBoardService;
import eapli.base.exceptions.DuplicateCreationException;
import eapli.base.exceptions.ParameterNullBlankException;

public class ShareBoardController {
    public boolean shareBoard(String boardTitle, String email, boolean permission) throws ParameterNullBlankException, DuplicateCreationException {
        ShareBoardService service = new ShareBoardService();
        return service.shareBoard(boardTitle, email, permission);
    }
}
