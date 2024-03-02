package eapli.base.usermanagement.repositories;

import eapli.base.board.domain.Board;
import eapli.base.usermanagement.domain.BoardOwner;
import eapli.base.usermanagement.domain.BoardOwnerId;
import eapli.framework.domain.repositories.DomainRepository;

public interface BoardOwnerRepository extends DomainRepository<BoardOwnerId, BoardOwner> {
    BoardOwner findBoardOwnerByPerson();

    BoardOwner findBoardOwnerByBoard(Board board);

}

