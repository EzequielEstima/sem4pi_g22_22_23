package eapli.base.board.application.services;

import eapli.base.board.domain.Board;
import eapli.base.board.domain.Cell;
import eapli.base.board.dto.CellDTOWithColumnRowPostItCreator;
import eapli.base.board.dto.CellDTOWithColumnRowPostItCreatorMapper;
import eapli.base.board.repositories.BoardRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.domain.Person;

import javax.persistence.NoResultException;
import java.util.ArrayList;
import java.util.List;

public class BoardInformationService {

    public List<CellDTOWithColumnRowPostItCreator> getBoardCellsInformation(String title){

        BoardRepository boardRepository = PersistenceContext.repositories().boardRepository();
        Board board = boardRepository.findBoardByTitle(title);
        List<Cell> cellsList = boardRepository.getAllCellsFromABoard(board);
        List<CellDTOWithColumnRowPostItCreator> listCellDTO = new ArrayList<>();

        for (Cell cell: cellsList) {
            if(cell.hasPostIt()) {
                try {
                    Person person = boardRepository.getCreatorOfAPostItBoardOwner(cell);
                    listCellDTO.add(CellDTOWithColumnRowPostItCreatorMapper.toDTO(cell, person));
                } catch (NoResultException owner) {
                    try {
                        Person person = boardRepository.getCreatorOfAPostItBoardParticipant(cell);
                        listCellDTO.add(CellDTOWithColumnRowPostItCreatorMapper.toDTO(cell, person));
                    } catch (NoResultException participant) {
                        listCellDTO.add(CellDTOWithColumnRowPostItCreatorMapper.toDTO(cell, null));
                    }
                }
            }else{
                listCellDTO.add(CellDTOWithColumnRowPostItCreatorMapper.toDTO(cell, null));
            }
        }
        return listCellDTO;
    }
}
