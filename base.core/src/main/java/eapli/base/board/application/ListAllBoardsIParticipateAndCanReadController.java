package eapli.base.board.application;

import eapli.base.board.application.services.ListBoardsService;
import eapli.base.board.dto.BoardDTOWithTitle;

import java.util.List;

public class ListAllBoardsIParticipateAndCanReadController {

    public List<BoardDTOWithTitle> listAllBoardsIParticipateAndCanRead() {
        return new ListBoardsService().listAllBoardsIParticipateAndCanRead();
    }
}
