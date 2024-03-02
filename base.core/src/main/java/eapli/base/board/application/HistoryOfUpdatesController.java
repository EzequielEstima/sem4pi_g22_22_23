package eapli.base.board.application;

import eapli.base.board.application.services.CreateBoardService;
import eapli.base.board.application.services.HistoryOfUpdatesService;

import java.util.List;

public class HistoryOfUpdatesController {

    private final HistoryOfUpdatesService historyOfUpdatesService  = new HistoryOfUpdatesService();

    public List<String> historyOfUpdates(String boardTitle){
        return historyOfUpdatesService.historyOfUpdates(boardTitle);
    }
}
