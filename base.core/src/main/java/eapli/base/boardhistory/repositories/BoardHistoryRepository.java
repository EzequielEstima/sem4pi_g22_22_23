package eapli.base.boardhistory.repositories;

import eapli.base.boardhistory.domain.BoardHistory;
import eapli.base.boardhistory.domain.BoardHistoryId;
import eapli.base.boardhistory.domain.Task;
import eapli.base.postitmanager.domain.PostIt;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.List;

public interface BoardHistoryRepository extends DomainRepository<BoardHistoryId, BoardHistory> {
    long getLastTaskId();

    BoardHistory getBoardHistoryByBoardTitle(String boardTitle);
    List<Task> historyOfUpdates(BoardHistoryId boardHistoryId);

    Task getLastTaskForPostIt(PostIt postIt);
}
