package eapli.base.board.application;

import eapli.base.board.application.services.ArchiveBoardService;
import eapli.base.exceptions.AlreadyDeactivatedException;

public class ArchiveBoardController {
    public boolean archiveBoard(String boardTitle) throws AlreadyDeactivatedException {
        ArchiveBoardService service = new ArchiveBoardService();
        return service.archiveBoard(boardTitle);
    }
}
