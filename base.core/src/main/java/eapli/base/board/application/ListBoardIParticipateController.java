package eapli.base.board.application;

import eapli.base.board.application.services.ListBoardsService;
import eapli.base.board.dto.BoardDTOWithTitle;

import java.util.List;

public class ListBoardIParticipateController {
    public List<BoardDTOWithTitle> listBoardsIParticipate() {
        ListBoardsService service = new ListBoardsService();
        return service.listBoardsIParticipate();
    }
}
