package eapli.base.board.application;

import eapli.base.board.application.services.BoardInformationService;
import eapli.base.board.dto.CellDTOWithColumnRowPostItCreator;

import java.util.List;

public class BoardInformationController {

    public List<CellDTOWithColumnRowPostItCreator> getBoardInformation(String boardId){
        return new BoardInformationService().getBoardCellsInformation(boardId);
    }
}
