package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.board.domain.Board;
import eapli.base.postitmanager.domain.PostIt;
import eapli.base.postitmanager.domain.PostItKey;
import eapli.base.postitmanager.repositories.PostItRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

public class JpaPostItRepository extends JpaAutoTxRepository<PostIt, PostItKey, PostItKey> implements PostItRepository {
    public JpaPostItRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(),
                "postItKey");
    }
    public JpaPostItRepository(final TransactionalContext autoTx) {
        super(autoTx, "postItKey");
    }

    @Override
    public PostIt getPostItInACell(Board board, Integer column, Integer row) {
        return createQuery("SELECT p FROM PostIt p WHERE p = " +
                "(SELECT c.postIt FROM Cell c WHERE c IN (SELECT cl FROM Board b JOIN b.cellList cl WHERE b = :board) " +
                "AND c.column.columnIdentifier.column_Identifier = :column AND c.row.rowIdentifier.row_Identifier = :row)", PostIt.class)
                .setParameter("boardTittle", board).setParameter("column",column).
                setParameter("row",row).getSingleResult();
    }

    @Override
    public PostIt getLastVersionOfPostIt(int version, long id) {
        return createQuery("SELECT p FROM PostIt p WHERE p.postItKey.postItVersion.version = :version " +
                "AND p.postItKey.postItIdentifier.postItId = :id", PostIt.class)
                .setParameter("version",version).setParameter("id",id).getSingleResult();
    }
}
