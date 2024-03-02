package eapli.base.persistence.impl.inmemory;

import eapli.base.board.domain.Board;
import eapli.base.board.domain.BoardTitle;
import eapli.base.board.domain.Cell;
import eapli.base.board.repositories.BoardRepository;
import eapli.base.usermanagement.domain.Person;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

import java.util.List;

public class InMemoryBoardRepository extends InMemoryDomainRepository<Board, BoardTitle> implements BoardRepository {

    @Override
    public long getLastCellId() {
        return 0;
    }

    @Override
    public List<Board> findAllBoardsIOwn(SystemUser user) {
        return null;
    }

    @Override
    public Board findBoardByTitle(String boardTitle) {
        return null;
    }

    @Override
    public List<Board> findAllBoardsIParticipateWithWritePermission(SystemUser user) {
        return null;
    }

    @Override
    public List<Cell> getAllCellsFromABoard(Board board) {
        return null;
    }

    @Override
    public List<Board> listAllBoardsIParticipateAndCanRead(SystemUser user) {
        return null;
    }

    @Override
    public Person getCreatorOfAPostItBoardParticipant(Cell cell) {
        return null;
    }

    @Override
    public Person getCreatorOfAPostItBoardOwner(Cell cell) {
        return null;
    }
}
