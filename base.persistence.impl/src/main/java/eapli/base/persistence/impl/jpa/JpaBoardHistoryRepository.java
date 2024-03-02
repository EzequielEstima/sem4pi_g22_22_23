package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.boardhistory.domain.BoardHistory;
import eapli.base.boardhistory.domain.BoardHistoryId;
import eapli.base.boardhistory.domain.Task;
import eapli.base.boardhistory.repositories.BoardHistoryRepository;
import eapli.base.postitmanager.domain.PostIt;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import java.util.List;

public class JpaBoardHistoryRepository extends JpaAutoTxRepository<BoardHistory, BoardHistoryId, BoardHistoryId> implements BoardHistoryRepository{
    public JpaBoardHistoryRepository(final TransactionalContext autoTx) {
        super(autoTx, "boarHistoryId");
    }

    public JpaBoardHistoryRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(),
                "boarHistoryId");
    }

    @Override
    public long getLastTaskId() {
        return createQuery("SELECT COUNT(t) FROM Task t", Long.class).getSingleResult();
    }

    @Override
    public BoardHistory getBoardHistoryByBoardTitle(String boardTitle) {
        return createQuery("SELECT b.boardHistory FROM Board b WHERE b.boardTitle.boardTitle =: boardTitle", BoardHistory.class)
                .setParameter("boardTitle",boardTitle).getSingleResult();
    }

    @Override
    public List<Task> historyOfUpdates(BoardHistoryId boardHistoryId) {
        return createQuery("SELECT t FROM Task t WHERE t IN (SELECT task FROM BoardHistory bh JOIN bh.taskList task WHERE bh.boardHistoryId = :boardHistoryId)", Task.class)
                .setParameter("boardHistoryId", boardHistoryId)
                .getResultList();
    }

    @Override
    public Task getLastTaskForPostIt(PostIt postIt) {
        return createQuery("SELECT t FROM Task t WHERE t.postIt = :postIt AND t.id = (SELECT MAX(t2.id) " +
                "FROM Task t2 WHERE t2.postIt = :postIt)",Task.class).
                setParameter("postIt", postIt).getSingleResult();
    }
}
