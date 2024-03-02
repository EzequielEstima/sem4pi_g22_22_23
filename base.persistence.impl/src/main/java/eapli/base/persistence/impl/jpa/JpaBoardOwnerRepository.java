package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.board.domain.Board;
import eapli.base.usermanagement.domain.BoardOwner;
import eapli.base.usermanagement.domain.BoardOwnerId;
import eapli.base.usermanagement.repositories.BoardOwnerRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.TypedQuery;

public class JpaBoardOwnerRepository extends JpaAutoTxRepository<BoardOwner, BoardOwnerId, BoardOwnerId> implements BoardOwnerRepository {

    public JpaBoardOwnerRepository(final TransactionalContext autoTx) {
        super(autoTx, "boardOwnerId");
    }

    public JpaBoardOwnerRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(),
                "boardOwnerId");
    }

    @Override
    public BoardOwner findBoardOwnerByPerson() {
        TypedQuery<BoardOwner> query = createQuery("SELECT b FROM BoardOwner b JOIN Person p on b.boardOwnerId = p.boardOwner.boardOwnerId",
                BoardOwner.class);
        return query.getSingleResult();
    }

    @Override
    public BoardOwner findBoardOwnerByBoard(Board board) {
        TypedQuery<BoardOwner> query = createQuery("SELECT bo FROM BoardOwner bo JOIN bo.boardList bl WHERE bl = :board",
                BoardOwner.class).setParameter("board", board);
        return query.getSingleResult();
    }
}
