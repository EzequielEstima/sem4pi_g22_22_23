package eapli.base.board.application;

import eapli.base.board.application.services.ListBoardsService;
import eapli.base.board.dto.BoardDTOWithTitle;

import java.util.List;

public class ListBoardsIOwnController {
    public List<BoardDTOWithTitle> listBoardsIOwn(){
        ListBoardsService service = new ListBoardsService();
        return service.listBoardsIOwn();
    }
}
