package presentation.historyOfUpdates;

import eapli.framework.actions.Action;

import java.net.Socket;

public class HistoryOfUpdatesAction implements Action {

    private Socket socket;

    public HistoryOfUpdatesAction(Socket socket){
        this.socket = socket;
    }
    @Override
    public boolean execute() {
        return new HistoryOfUpdatesUI(socket).doShow();
    }
}
