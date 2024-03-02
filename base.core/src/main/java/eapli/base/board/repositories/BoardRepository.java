package eapli.base.board.repositories;

import eapli.base.board.domain.Board;
import eapli.base.board.domain.BoardTitle;
import eapli.base.board.domain.Cell;
import eapli.base.usermanagement.domain.Person;
import eapli.framework.domain.repositories.DomainRepository;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import java.util.List;

public interface BoardRepository extends DomainRepository<BoardTitle, Board> {

    /**
     * Searches for the last cell id
     * @return the last cell id
     */
    long getLastCellId();

    /**
     * Searches for all boards owned by the user
     * @param user the user to search for
     * @return a list of boards owned by the user
     */
    List<Board> findAllBoardsIOwn(SystemUser user);

    /**
     * Searches for a board with the given title
     * @param boardTitle the title to search for
     * @return the board with the given title
     */
    Board findBoardByTitle(String boardTitle);

    /**
     * Searches for all boards in which the user is a participant
     * @param user the user to search for
     * @return a list of boards in which the user is a participant
     */
    List<Board> findAllBoardsIParticipateWithWritePermission(SystemUser user);

    List<Cell> getAllCellsFromABoard(Board board);

    List<Board> listAllBoardsIParticipateAndCanRead(SystemUser user);

    Person getCreatorOfAPostItBoardParticipant(Cell cell);

    Person getCreatorOfAPostItBoardOwner(Cell cell);



}
