package eapli.base.board.application.services;

import eapli.base.boardhistory.domain.BoardHistory;
import eapli.base.boardhistory.domain.Task;
import eapli.base.boardhistory.repositories.BoardHistoryRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;

import java.util.ArrayList;
import java.util.List;

public class HistoryOfUpdatesService {

    BoardHistoryRepository boardHistoryRepository = PersistenceContext.repositories().boardHistoryRepository();
    public List<String> historyOfUpdates(String boardTitle){

        List<String> taskList = new ArrayList<>();
        BoardHistory boardHistory = boardHistoryRepository.getBoardHistoryByBoardTitle(boardTitle);
        List<Task> taskEntityList = boardHistoryRepository.historyOfUpdates(boardHistory.identity());

        for (Task task : taskEntityList) {
            taskList.add(task.toString());
        }


        return taskList;
    }
}
