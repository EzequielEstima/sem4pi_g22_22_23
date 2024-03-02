package eapli.base.persistence.impl.inmemory;

import eapli.base.boardhistory.domain.BoardHistory;
import eapli.base.boardhistory.domain.BoardHistoryId;
import eapli.base.boardhistory.domain.Task;
import eapli.base.boardhistory.repositories.BoardHistoryRepository;
import eapli.base.postitmanager.domain.PostIt;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

import java.util.List;

public class InMemoryBoardHistoryRepository extends InMemoryDomainRepository<BoardHistory, BoardHistoryId> implements BoardHistoryRepository {
    @Override
    public long getLastTaskId() {
        return 0;
    }

    @Override
    public BoardHistory getBoardHistoryByBoardTitle(String boardTitle) {
        return null;
    }

    @Override
    public List<Task> historyOfUpdates(BoardHistoryId boardHistoryId) {
        return null;
    }

    @Override
    public Task getLastTaskForPostIt(PostIt postIt) {
        return null;
    }
}
