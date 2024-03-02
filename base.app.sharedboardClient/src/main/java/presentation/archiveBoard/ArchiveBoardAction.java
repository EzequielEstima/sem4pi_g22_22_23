package presentation.archiveBoard;


import eapli.framework.actions.Action;

import java.net.Socket;

public class ArchiveBoardAction implements Action {
    private final Socket socket;
    public ArchiveBoardAction(Socket socket){
        this.socket = socket;
    }

    @Override
    public boolean execute() {
        return new ArchiveBoardUI(socket).show();
    }
}
